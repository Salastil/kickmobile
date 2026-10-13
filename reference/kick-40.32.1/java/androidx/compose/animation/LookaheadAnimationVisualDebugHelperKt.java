package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: LookaheadAnimationVisualDebugHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aT\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\t2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a*\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"colorIndex", "", "keyToColor", "Landroidx/collection/MutableScatterMap;", "", "Landroidx/compose/ui/graphics/Color;", "LookaheadAnimationVisualDebugging", "", "isEnabled", "", "overlayColor", "multipleMatchesColor", "unmatchedElementColor", "isShowKeyLabelEnabled", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "LookaheadAnimationVisualDebugging-gUzqikQ", "(ZJJJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "CustomizedLookaheadAnimationVisualDebugging", "debugColor", "CustomizedLookaheadAnimationVisualDebugging-Iv8Zu3U", "(JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "animation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LookaheadAnimationVisualDebugHelperKt {
    private static int colorIndex;
    private static final MutableScatterMap<Object, Color> keyToColor = new MutableScatterMap<>(0, 1, null);

    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:49:0x008c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:54:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:74:0x00db  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:80:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:81:0x0107  */
    /* JADX WARN: Code duplicated, block: B:83:0x010b  */
    /* JADX WARN: Code duplicated, block: B:84:0x010e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0116  */
    /* JADX WARN: Code duplicated, block: B:90:0x0140  */
    /* JADX WARN: Code duplicated, block: B:92:0x014c  */
    /* JADX WARN: Code duplicated, block: B:95:0x015c  */
    /* JADX WARN: Code duplicated, block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: LookaheadAnimationVisualDebugging-gUzqikQ, reason: not valid java name */
    public static final void m1406LookaheadAnimationVisualDebugginggUzqikQ(boolean z, long j, long j2, long j3, boolean z2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        long j4;
        int i4;
        long j5;
        int i5;
        int i6;
        long j6;
        int i7;
        int i8;
        int i9;
        boolean z4;
        final boolean z5;
        boolean z6;
        final long j7;
        final long j8;
        final long j9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jColor;
        long jColor2;
        long jColor3;
        boolean z7;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(1722790302);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LookaheadAnimationVisualDebugging)N(isEnabled,overlayColor:c#ui.graphics.Color,multipleMatchesColor:c#ui.graphics.Color,unmatchedElementColor:c#ui.graphics.Color,isShowKeyLabelEnabled,content)559@20834L353:LookaheadAnimationVisualDebugHelper.kt#xbi5r1");
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 = i | 6;
            z3 = z;
        } else if ((i & 6) == 0) {
            z3 = z;
            i3 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
        } else {
            z3 = z;
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                j4 = j;
                i3 |= composerStartRestartGroup.changed(j4) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    j5 = j2;
                    if (composerStartRestartGroup.changed(j5)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        j6 = j3;
                        if (composerStartRestartGroup.changed(j6)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 24576) == 0) {
                            if (composerStartRestartGroup.changed(z2)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                            i3 |= i10;
                        }
                        if ((i3 & 74899) != 74898) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            z5 = z2;
                            z6 = z3;
                            j7 = j4;
                            j8 = j5;
                            j9 = j6;
                        } else {
                            if (i11 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i12 != 0) {
                                jColor = ColorKt.Color(2150934611L);
                            } else {
                                jColor = j4;
                            }
                            if (i4 != 0) {
                                jColor2 = ColorKt.Color(4293542709L);
                            } else {
                                jColor2 = j5;
                            }
                            if (i6 != 0) {
                                jColor3 = ColorKt.Color(4288323750L);
                            } else {
                                jColor3 = j6;
                            }
                            if (i8 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
                            }
                            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z6, jColor, jColor2, jColor3, z7, null)), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j7 = jColor;
                            j8 = jColor2;
                            j9 = jColor3;
                            z5 = z7;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final boolean z8 = z6;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    LookaheadAnimationVisualDebugHelperKt.m1406LookaheadAnimationVisualDebugginggUzqikQ(z8, j7, j8, j9, z5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 24576;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 74899) != 74898) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        z5 = z2;
                        z6 = z3;
                        j7 = j4;
                        j8 = j5;
                        j9 = j6;
                    } else {
                        if (i11 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i12 != 0) {
                            jColor = ColorKt.Color(2150934611L);
                        } else {
                            jColor = j4;
                        }
                        if (i4 != 0) {
                            jColor2 = ColorKt.Color(4293542709L);
                        } else {
                            jColor2 = j5;
                        }
                        if (i6 != 0) {
                            jColor3 = ColorKt.Color(4288323750L);
                        } else {
                            jColor3 = j6;
                        }
                        if (i8 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
                        }
                        CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z6, jColor, jColor2, jColor3, z7, null)), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j7 = jColor;
                        j8 = jColor2;
                        j9 = jColor3;
                        z5 = z7;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final boolean z9 = z6;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i13) {
                                LookaheadAnimationVisualDebugHelperKt.m1406LookaheadAnimationVisualDebugginggUzqikQ(z9, j7, j8, j9, z5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 3072;
                j6 = j3;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 74899) != 74898) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        z5 = z2;
                        z6 = z3;
                        j7 = j4;
                        j8 = j5;
                        j9 = j6;
                    } else {
                        if (i11 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i12 != 0) {
                            jColor = ColorKt.Color(2150934611L);
                        } else {
                            jColor = j4;
                        }
                        if (i4 != 0) {
                            jColor2 = ColorKt.Color(4293542709L);
                        } else {
                            jColor2 = j5;
                        }
                        if (i6 != 0) {
                            jColor3 = ColorKt.Color(4288323750L);
                        } else {
                            jColor3 = j6;
                        }
                        if (i8 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
                        }
                        CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z6, jColor, jColor2, jColor3, z7, null)), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j7 = jColor;
                        j8 = jColor2;
                        j9 = jColor3;
                        z5 = z7;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final boolean z10 = z6;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i13) {
                                LookaheadAnimationVisualDebugHelperKt.m1406LookaheadAnimationVisualDebugginggUzqikQ(z10, j7, j8, j9, z5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((i3 & 74899) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z5 = z2;
                    z6 = z3;
                    j7 = j4;
                    j8 = j5;
                    j9 = j6;
                } else {
                    if (i11 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i12 != 0) {
                        jColor = ColorKt.Color(2150934611L);
                    } else {
                        jColor = j4;
                    }
                    if (i4 != 0) {
                        jColor2 = ColorKt.Color(4293542709L);
                    } else {
                        jColor2 = j5;
                    }
                    if (i6 != 0) {
                        jColor3 = ColorKt.Color(4288323750L);
                    } else {
                        jColor3 = j6;
                    }
                    if (i8 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z6, jColor, jColor2, jColor3, z7, null)), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j7 = jColor;
                    j8 = jColor2;
                    j9 = jColor3;
                    z5 = z7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final boolean z11 = z6;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            LookaheadAnimationVisualDebugHelperKt.m1406LookaheadAnimationVisualDebugginggUzqikQ(z11, j7, j8, j9, z5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 384;
            j5 = j2;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    j6 = j3;
                    if (composerStartRestartGroup.changed(j6)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 74899) != 74898) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        z5 = z2;
                        z6 = z3;
                        j7 = j4;
                        j8 = j5;
                        j9 = j6;
                    } else {
                        if (i11 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i12 != 0) {
                            jColor = ColorKt.Color(2150934611L);
                        } else {
                            jColor = j4;
                        }
                        if (i4 != 0) {
                            jColor2 = ColorKt.Color(4293542709L);
                        } else {
                            jColor2 = j5;
                        }
                        if (i6 != 0) {
                            jColor3 = ColorKt.Color(4288323750L);
                        } else {
                            jColor3 = j6;
                        }
                        if (i8 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
                        }
                        CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z6, jColor, jColor2, jColor3, z7, null)), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j7 = jColor;
                        j8 = jColor2;
                        j9 = jColor3;
                        z5 = z7;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final boolean z12 = z6;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i13) {
                                LookaheadAnimationVisualDebugHelperKt.m1406LookaheadAnimationVisualDebugginggUzqikQ(z12, j7, j8, j9, z5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((i3 & 74899) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z5 = z2;
                    z6 = z3;
                    j7 = j4;
                    j8 = j5;
                    j9 = j6;
                } else {
                    if (i11 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i12 != 0) {
                        jColor = ColorKt.Color(2150934611L);
                    } else {
                        jColor = j4;
                    }
                    if (i4 != 0) {
                        jColor2 = ColorKt.Color(4293542709L);
                    } else {
                        jColor2 = j5;
                    }
                    if (i6 != 0) {
                        jColor3 = ColorKt.Color(4288323750L);
                    } else {
                        jColor3 = j6;
                    }
                    if (i8 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z6, jColor, jColor2, jColor3, z7, null)), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j7 = jColor;
                    j8 = jColor2;
                    j9 = jColor3;
                    z5 = z7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final boolean z13 = z6;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            LookaheadAnimationVisualDebugHelperKt.m1406LookaheadAnimationVisualDebugginggUzqikQ(z13, j7, j8, j9, z5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            j6 = j3;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((i3 & 74899) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z5 = z2;
                    z6 = z3;
                    j7 = j4;
                    j8 = j5;
                    j9 = j6;
                } else {
                    if (i11 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i12 != 0) {
                        jColor = ColorKt.Color(2150934611L);
                    } else {
                        jColor = j4;
                    }
                    if (i4 != 0) {
                        jColor2 = ColorKt.Color(4293542709L);
                    } else {
                        jColor2 = j5;
                    }
                    if (i6 != 0) {
                        jColor3 = ColorKt.Color(4288323750L);
                    } else {
                        jColor3 = j6;
                    }
                    if (i8 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z6, jColor, jColor2, jColor3, z7, null)), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j7 = jColor;
                    j8 = jColor2;
                    j9 = jColor3;
                    z5 = z7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final boolean z14 = z6;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            LookaheadAnimationVisualDebugHelperKt.m1406LookaheadAnimationVisualDebugginggUzqikQ(z14, j7, j8, j9, z5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
            if ((i3 & 74899) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z5 = z2;
                z6 = z3;
                j7 = j4;
                j8 = j5;
                j9 = j6;
            } else {
                if (i11 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if (i12 != 0) {
                    jColor = ColorKt.Color(2150934611L);
                } else {
                    jColor = j4;
                }
                if (i4 != 0) {
                    jColor2 = ColorKt.Color(4293542709L);
                } else {
                    jColor2 = j5;
                }
                if (i6 != 0) {
                    jColor3 = ColorKt.Color(4288323750L);
                } else {
                    jColor3 = j6;
                }
                if (i8 != 0) {
                    z7 = false;
                } else {
                    z7 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
                }
                CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z6, jColor, jColor2, jColor3, z7, null)), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j7 = jColor;
                j8 = jColor2;
                j9 = jColor3;
                z5 = z7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final boolean z15 = z6;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        LookaheadAnimationVisualDebugHelperKt.m1406LookaheadAnimationVisualDebugginggUzqikQ(z15, j7, j8, j9, z5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        j4 = j;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                j5 = j2;
                if (composerStartRestartGroup.changed(j5)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    j6 = j3;
                    if (composerStartRestartGroup.changed(j6)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 74899) != 74898) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        z5 = z2;
                        z6 = z3;
                        j7 = j4;
                        j8 = j5;
                        j9 = j6;
                    } else {
                        if (i11 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i12 != 0) {
                            jColor = ColorKt.Color(2150934611L);
                        } else {
                            jColor = j4;
                        }
                        if (i4 != 0) {
                            jColor2 = ColorKt.Color(4293542709L);
                        } else {
                            jColor2 = j5;
                        }
                        if (i6 != 0) {
                            jColor3 = ColorKt.Color(4288323750L);
                        } else {
                            jColor3 = j6;
                        }
                        if (i8 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
                        }
                        CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z6, jColor, jColor2, jColor3, z7, null)), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j7 = jColor;
                        j8 = jColor2;
                        j9 = jColor3;
                        z5 = z7;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final boolean z16 = z6;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i13) {
                                LookaheadAnimationVisualDebugHelperKt.m1406LookaheadAnimationVisualDebugginggUzqikQ(z16, j7, j8, j9, z5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((i3 & 74899) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z5 = z2;
                    z6 = z3;
                    j7 = j4;
                    j8 = j5;
                    j9 = j6;
                } else {
                    if (i11 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i12 != 0) {
                        jColor = ColorKt.Color(2150934611L);
                    } else {
                        jColor = j4;
                    }
                    if (i4 != 0) {
                        jColor2 = ColorKt.Color(4293542709L);
                    } else {
                        jColor2 = j5;
                    }
                    if (i6 != 0) {
                        jColor3 = ColorKt.Color(4288323750L);
                    } else {
                        jColor3 = j6;
                    }
                    if (i8 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z6, jColor, jColor2, jColor3, z7, null)), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j7 = jColor;
                    j8 = jColor2;
                    j9 = jColor3;
                    z5 = z7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final boolean z17 = z6;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            LookaheadAnimationVisualDebugHelperKt.m1406LookaheadAnimationVisualDebugginggUzqikQ(z17, j7, j8, j9, z5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            j6 = j3;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((i3 & 74899) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z5 = z2;
                    z6 = z3;
                    j7 = j4;
                    j8 = j5;
                    j9 = j6;
                } else {
                    if (i11 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i12 != 0) {
                        jColor = ColorKt.Color(2150934611L);
                    } else {
                        jColor = j4;
                    }
                    if (i4 != 0) {
                        jColor2 = ColorKt.Color(4293542709L);
                    } else {
                        jColor2 = j5;
                    }
                    if (i6 != 0) {
                        jColor3 = ColorKt.Color(4288323750L);
                    } else {
                        jColor3 = j6;
                    }
                    if (i8 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z6, jColor, jColor2, jColor3, z7, null)), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j7 = jColor;
                    j8 = jColor2;
                    j9 = jColor3;
                    z5 = z7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final boolean z18 = z6;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            LookaheadAnimationVisualDebugHelperKt.m1406LookaheadAnimationVisualDebugginggUzqikQ(z18, j7, j8, j9, z5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
            if ((i3 & 74899) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z5 = z2;
                z6 = z3;
                j7 = j4;
                j8 = j5;
                j9 = j6;
            } else {
                if (i11 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if (i12 != 0) {
                    jColor = ColorKt.Color(2150934611L);
                } else {
                    jColor = j4;
                }
                if (i4 != 0) {
                    jColor2 = ColorKt.Color(4293542709L);
                } else {
                    jColor2 = j5;
                }
                if (i6 != 0) {
                    jColor3 = ColorKt.Color(4288323750L);
                } else {
                    jColor3 = j6;
                }
                if (i8 != 0) {
                    z7 = false;
                } else {
                    z7 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
                }
                CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z6, jColor, jColor2, jColor3, z7, null)), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j7 = jColor;
                j8 = jColor2;
                j9 = jColor3;
                z5 = z7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final boolean z19 = z6;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        LookaheadAnimationVisualDebugHelperKt.m1406LookaheadAnimationVisualDebugginggUzqikQ(z19, j7, j8, j9, z5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        j5 = j2;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                j6 = j3;
                if (composerStartRestartGroup.changed(j6)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((i3 & 74899) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z5 = z2;
                    z6 = z3;
                    j7 = j4;
                    j8 = j5;
                    j9 = j6;
                } else {
                    if (i11 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i12 != 0) {
                        jColor = ColorKt.Color(2150934611L);
                    } else {
                        jColor = j4;
                    }
                    if (i4 != 0) {
                        jColor2 = ColorKt.Color(4293542709L);
                    } else {
                        jColor2 = j5;
                    }
                    if (i6 != 0) {
                        jColor3 = ColorKt.Color(4288323750L);
                    } else {
                        jColor3 = j6;
                    }
                    if (i8 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z6, jColor, jColor2, jColor3, z7, null)), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j7 = jColor;
                    j8 = jColor2;
                    j9 = jColor3;
                    z5 = z7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final boolean z110 = z6;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            LookaheadAnimationVisualDebugHelperKt.m1406LookaheadAnimationVisualDebugginggUzqikQ(z110, j7, j8, j9, z5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
            if ((i3 & 74899) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z5 = z2;
                z6 = z3;
                j7 = j4;
                j8 = j5;
                j9 = j6;
            } else {
                if (i11 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if (i12 != 0) {
                    jColor = ColorKt.Color(2150934611L);
                } else {
                    jColor = j4;
                }
                if (i4 != 0) {
                    jColor2 = ColorKt.Color(4293542709L);
                } else {
                    jColor2 = j5;
                }
                if (i6 != 0) {
                    jColor3 = ColorKt.Color(4288323750L);
                } else {
                    jColor3 = j6;
                }
                if (i8 != 0) {
                    z7 = false;
                } else {
                    z7 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
                }
                CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z6, jColor, jColor2, jColor3, z7, null)), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j7 = jColor;
                j8 = jColor2;
                j9 = jColor3;
                z5 = z7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final boolean z111 = z6;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        LookaheadAnimationVisualDebugHelperKt.m1406LookaheadAnimationVisualDebugginggUzqikQ(z111, j7, j8, j9, z5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        j6 = j3;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
            if ((i3 & 74899) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z5 = z2;
                z6 = z3;
                j7 = j4;
                j8 = j5;
                j9 = j6;
            } else {
                if (i11 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if (i12 != 0) {
                    jColor = ColorKt.Color(2150934611L);
                } else {
                    jColor = j4;
                }
                if (i4 != 0) {
                    jColor2 = ColorKt.Color(4293542709L);
                } else {
                    jColor2 = j5;
                }
                if (i6 != 0) {
                    jColor3 = ColorKt.Color(4288323750L);
                } else {
                    jColor3 = j6;
                }
                if (i8 != 0) {
                    z7 = false;
                } else {
                    z7 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
                }
                CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z6, jColor, jColor2, jColor3, z7, null)), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j7 = jColor;
                j8 = jColor2;
                j9 = jColor3;
                z5 = z7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final boolean z112 = z6;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        LookaheadAnimationVisualDebugHelperKt.m1406LookaheadAnimationVisualDebugginggUzqikQ(z112, j7, j8, j9, z5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i10 = 131072;
            } else {
                i10 = 65536;
            }
            i3 |= i10;
        }
        if ((i3 & 74899) != 74898) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z5 = z2;
            z6 = z3;
            j7 = j4;
            j8 = j5;
            j9 = j6;
        } else {
            if (i11 != 0) {
                z6 = true;
            } else {
                z6 = z3;
            }
            if (i12 != 0) {
                jColor = ColorKt.Color(2150934611L);
            } else {
                jColor = j4;
            }
            if (i4 != 0) {
                jColor2 = ColorKt.Color(4293542709L);
            } else {
                jColor2 = j5;
            }
            if (i6 != 0) {
                jColor3 = ColorKt.Color(4288323750L);
            } else {
                jColor3 = j6;
            }
            if (i8 != 0) {
                z7 = false;
            } else {
                z7 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
            }
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z6, jColor, jColor2, jColor3, z7, null)), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j7 = jColor;
            j8 = jColor2;
            j9 = jColor3;
            z5 = z7;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z113 = z6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    LookaheadAnimationVisualDebugHelperKt.m1406LookaheadAnimationVisualDebugginggUzqikQ(z113, j7, j8, j9, z5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: renamed from: CustomizedLookaheadAnimationVisualDebugging-Iv8Zu3U, reason: not valid java name */
    public static final void m1405CustomizedLookaheadAnimationVisualDebuggingIv8Zu3U(final long j, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1657127863);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomizedLookaheadAnimationVisualDebugging)N(debugColor:c#ui.graphics.Color,content)592@22107L129:LookaheadAnimationVisualDebugHelper.kt#xbi5r1");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1657127863, i2, -1, "androidx.compose.animation.CustomizedLookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:591)");
            }
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugColor().provides(Color.m7328boximpl(j)), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$CustomizedLookaheadAnimationVisualDebugging$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    LookaheadAnimationVisualDebugHelperKt.m1405CustomizedLookaheadAnimationVisualDebuggingIv8Zu3U(j, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
