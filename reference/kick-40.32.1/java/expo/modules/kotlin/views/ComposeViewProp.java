package expo.modules.kotlin.views;

import android.view.View;
import androidx.compose.runtime.MutableState;
import com.facebook.react.bridge.Dynamic;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.PropSetException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.ConverterContext;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;

/* JADX INFO: compiled from: ComposeViewProp.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0004\b\t\u0010\nJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0001J\u0006\u0010\u0019\u001a\u00020\u0000R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u000e8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006\u001e"}, d2 = {"Lexpo/modules/kotlin/views/ComposeViewProp;", "Lexpo/modules/kotlin/views/AnyViewProp;", "name", "", "anyType", "Lexpo/modules/kotlin/types/AnyType;", "propertyGetter", "Lkotlin/Function1;", "", "<init>", "(Ljava/lang/String;Lexpo/modules/kotlin/types/AnyType;Lkotlin/jvm/functions/Function1;)V", "getPropertyGetter", "()Lkotlin/jvm/functions/Function1;", "_isStateProp", "", "set", "", "prop", "Lcom/facebook/react/bridge/Dynamic;", "onView", "Landroid/view/View;", "converterContext", "Lexpo/modules/kotlin/types/ConverterContext;", "copyPropsWithNewValue", "currentProps", "asStateProp", "isNullable", "()Z", "isStateProp", "isStateProp$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ComposeViewProp extends AnyViewProp {
    public static final int $stable = 8;
    private boolean _isStateProp;
    private final boolean isNullable;
    private final Function1<Object, Object> propertyGetter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeViewProp(String name, AnyType anyType, Function1<Object, ? extends Object> propertyGetter) {
        super(name, anyType);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(anyType, "anyType");
        Intrinsics.checkNotNullParameter(propertyGetter, "propertyGetter");
        this.propertyGetter = propertyGetter;
        this.isNullable = anyType.getTypeDescriptor().getTypeInfo().isNullable();
    }

    public final Function1<Object, Object> getPropertyGetter() {
        return this.propertyGetter;
    }

    @Override // expo.modules.kotlin.views.AnyViewProp
    public void set(Dynamic prop, View onView, ConverterContext converterContext) throws PropSetException {
        Intrinsics.checkNotNullParameter(prop, "prop");
        Intrinsics.checkNotNullParameter(onView, "onView");
        Intrinsics.checkNotNullParameter(converterContext, "converterContext");
        set((Object) prop, onView, converterContext);
    }

    @Override // expo.modules.kotlin.views.AnyViewProp
    public void set(Object prop, View onView, ConverterContext converterContext) throws PropSetException {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(onView, "onView");
        Intrinsics.checkNotNullParameter(converterContext, "converterContext");
        try {
            ComposeProps props = ((ExpoComposeView) onView).getProps();
            if (props != null) {
                if (onView instanceof ComposeFunctionHolder) {
                    Object objCopyPropsWithNewValue = copyPropsWithNewValue(prop, (ComposeProps) ((ComposeFunctionHolder) onView).getPropsMutableState().getValue(), converterContext);
                    if (objCopyPropsWithNewValue != null) {
                        MutableState propsMutableState = ((ComposeFunctionHolder) onView).getPropsMutableState();
                        Intrinsics.checkNotNull(propsMutableState, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.Any?>");
                        propsMutableState.setValue(objCopyPropsWithNewValue);
                    }
                } else {
                    Object objInvoke = getPropertyGetter().invoke(props);
                    if (objInvoke instanceof MutableState) {
                        ((MutableState) objInvoke).setValue(AnyType.convert$default(getType(), prop, converterContext, false, 4, null));
                    } else {
                        Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ Property " + getName() + " is not a MutableState in " + onView.getClass(), null, 2, null);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            if (th instanceof CodedException) {
                unexpectedException = (CodedException) th;
            } else if (th instanceof expo.modules.core.errors.CodedException) {
                expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                unexpectedException = new CodedException(codedException.getCode(), codedException.getMessage(), codedException.getCause());
            } else {
                unexpectedException = new UnexpectedException(th);
            }
            throw new PropSetException(getName(), Reflection.getOrCreateKotlinClass(onView.getClass()), unexpectedException);
        }
    }

    public final Object copyPropsWithNewValue(Object prop, Object currentProps, ConverterContext converterContext) {
        Object next;
        Object next2;
        Intrinsics.checkNotNullParameter(currentProps, "currentProps");
        Intrinsics.checkNotNullParameter(converterContext, "converterContext");
        Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(currentProps.getClass())).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((KFunction) next).getName(), "copy"));
        KFunction kFunction = (KFunction) next;
        if (kFunction == null) {
            Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ Props are not a data class with default values for all properties, cannot set prop " + getName() + " dynamically.", null, 2, null);
            return null;
        }
        KParameter instanceParameter = KCallables.getInstanceParameter(kFunction);
        Intrinsics.checkNotNull(instanceParameter);
        Iterator<T> it2 = kFunction.getParameters().iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
        } while (!Intrinsics.areEqual(((KParameter) next2).getName(), getName()));
        KParameter kParameter = (KParameter) next2;
        if (kParameter == null) {
            return null;
        }
        return kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, currentProps), TuplesKt.to(kParameter, AnyType.convert$default(getType(), prop, converterContext, false, 4, null))));
    }

    public final ComposeViewProp asStateProp() {
        this._isStateProp = true;
        return this;
    }

    @Override // expo.modules.kotlin.views.AnyViewProp
    /* JADX INFO: renamed from: isNullable, reason: from getter */
    public boolean getIsNullable() {
        return this.isNullable;
    }

    @Override // expo.modules.kotlin.views.AnyViewProp
    /* JADX INFO: renamed from: isStateProp$expo_modules_core_release, reason: from getter */
    public boolean get_isStateProp() {
        return this._isStateProp;
    }
}
