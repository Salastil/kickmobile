package com.facebook.react.uimanager.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: compiled from: ReactProp.kt */
/* JADX INFO: loaded from: classes6.dex */
@Target({ElementType.METHOD})
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016Br\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\u00020\u0003B\u0004\b\b(\u0005\u0012\u0015\b\u0002\u0010\u0006\u001a\u00020\u0007B\u000b\b\u0006!\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0012\u0011\b\u0002\u0010\b\u001a\u00020\tB\u0007\b\u0005\u001d\u0000\u0000\u0000\u0000\u0012\u000e\b\u0002\u0010\n\u001a\u00020\u000bB\u0004\b\u0003\u0010\u0000\u0012\u000e\b\u0002\u0010\f\u001a\u00020\rB\u0004\b\u0004\u0010\u0000\u0012\u000e\b\u0002\u0010\u000e\u001a\u00020\u000fB\u0004\b\u0007\u0010\u0000R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0010R\u000f\u0010\u0004\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0010R\u000f\u0010\u0006\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0011R\u000f\u0010\b\u001a\u00020\t¢\u0006\u0006\u001a\u0004\b\b\u0010\u0012R\u000f\u0010\n\u001a\u00020\u000b¢\u0006\u0006\u001a\u0004\b\n\u0010\u0013R\u000f\u0010\f\u001a\u00020\r¢\u0006\u0006\u001a\u0004\b\f\u0010\u0014R\u000f\u0010\u000e\u001a\u00020\u000f¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/facebook/react/uimanager/annotations/ReactProp;", "", "name", "", "customType", "__default_type__", "defaultDouble", "", "defaultFloat", "", "defaultInt", "", "defaultLong", "", "defaultBoolean", "", "()Ljava/lang/String;", "()D", "()F", "()I", "()J", "()Z", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
public @interface ReactProp {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String USE_DEFAULT_TYPE = "__default_type__";

    String customType() default "__default_type__";

    boolean defaultBoolean() default false;

    double defaultDouble() default 0.0d;

    float defaultFloat() default 0.0f;

    int defaultInt() default 0;

    long defaultLong() default 0;

    String name();

    /* JADX INFO: compiled from: ReactProp.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/uimanager/annotations/ReactProp$Companion;", "", "<init>", "()V", "USE_DEFAULT_TYPE", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String USE_DEFAULT_TYPE = "__default_type__";

        private Companion() {
        }
    }
}
