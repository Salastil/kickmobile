package com.google.android.gms.internal.cast;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzgn extends AnimatorListenerAdapter {
    private final SimpleArrayMap zza = new SimpleArrayMap();

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.zza.put(animator, true);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.zza.put(animator, false);
    }

    protected final boolean zza(Animator animator) {
        SimpleArrayMap simpleArrayMap = this.zza;
        return simpleArrayMap.containsKey(animator) && ((Boolean) simpleArrayMap.get(animator)).booleanValue();
    }
}
