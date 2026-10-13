package com.fingerprintjs.android.fpjs_pro;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H×\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/ConfidenceScore;", "", "", FirebaseAnalytics.Param.SCORE, "<init>", "(D)V", "component1", "()D", "copy", "(D)Lcom/fingerprintjs/android/fpjs_pro/ConfidenceScore;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "D", "getScore"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ConfidenceScore {
    private final double score;

    public ConfidenceScore(double d) {
        this.score = d;
    }

    public final double getScore() {
        return this.score;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ConfidenceScore) && Double.compare(this.score, ((ConfidenceScore) other).score) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(this.score);
    }

    public final String toString() {
        return "ConfidenceScore(score=" + this.score + ")";
    }

    public static /* synthetic */ ConfidenceScore copy$default(ConfidenceScore confidenceScore, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            d = confidenceScore.score;
        }
        return confidenceScore.copy(d);
    }

    public final ConfidenceScore copy(double score) {
        return new ConfidenceScore(score);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getScore() {
        return this.score;
    }
}
