package jakarta.inject;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes9.dex */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Named {
    String value() default "";
}
