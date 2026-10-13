package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import com.google.common.base.Ascii;
import io.ktor.sse.ServerSentEventKt;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class KeyTrigger extends Key {
    public static final String CROSS = "CROSS";
    public static final int KEY_TYPE = 5;
    static final String NAME = "KeyTrigger";
    public static final String NEGATIVE_CROSS = "negativeCross";
    public static final String POSITIVE_CROSS = "positiveCross";
    public static final String POST_LAYOUT = "postLayout";
    private static final String TAG = "KeyTrigger";
    public static final String TRIGGER_COLLISION_ID = "triggerCollisionId";
    public static final String TRIGGER_COLLISION_VIEW = "triggerCollisionView";
    public static final String TRIGGER_ID = "triggerID";
    public static final String TRIGGER_RECEIVER = "triggerReceiver";
    public static final String TRIGGER_SLACK = "triggerSlack";
    public static final String VIEW_TRANSITION_ON_CROSS = "viewTransitionOnCross";
    public static final String VIEW_TRANSITION_ON_NEGATIVE_CROSS = "viewTransitionOnNegativeCross";
    public static final String VIEW_TRANSITION_ON_POSITIVE_CROSS = "viewTransitionOnPositiveCross";
    private float mFireLastPos;
    private int mCurveFit = -1;
    private String mCross = null;
    private int mTriggerReceiver = UNSET;
    private String mNegativeCross = null;
    private String mPositiveCross = null;
    private int mTriggerID = UNSET;
    private int mTriggerCollisionId = UNSET;
    private View mTriggerCollisionView = null;
    float mTriggerSlack = 0.1f;
    private boolean mFireCrossReset = true;
    private boolean mFireNegativeReset = true;
    private boolean mFirePositiveReset = true;
    private float mFireThreshold = Float.NaN;
    private boolean mPostLayout = false;
    int mViewTransitionOnNegativeCross = UNSET;
    int mViewTransitionOnPositiveCross = UNSET;
    int mViewTransitionOnCross = UNSET;
    RectF mCollisionRect = new RectF();
    RectF mTargetRect = new RectF();
    HashMap<String, Method> mMethodHashMap = new HashMap<>();

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> splines) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> attributes) {
    }

    public KeyTrigger() {
        this.mType = 5;
        this.mCustomConstraints = new HashMap<>();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attrs) {
        Loader.read(this, context.obtainStyledAttributes(attrs, R.styleable.KeyTrigger), context);
    }

    int getCurveFit() {
        return this.mCurveFit;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String tag, Object value) {
        tag.hashCode();
        byte b = -1;
        switch (tag.hashCode()) {
            case -1594793529:
                if (tag.equals("positiveCross")) {
                    b = 0;
                }
                break;
            case -966421266:
                if (tag.equals("viewTransitionOnPositiveCross")) {
                    b = 1;
                }
                break;
            case -786670827:
                if (tag.equals("triggerCollisionId")) {
                    b = 2;
                }
                break;
            case -648752941:
                if (tag.equals("triggerID")) {
                    b = 3;
                }
                break;
            case -638126837:
                if (tag.equals("negativeCross")) {
                    b = 4;
                }
                break;
            case -76025313:
                if (tag.equals("triggerCollisionView")) {
                    b = 5;
                }
                break;
            case -9754574:
                if (tag.equals("viewTransitionOnNegativeCross")) {
                    b = 6;
                }
                break;
            case 64397344:
                if (tag.equals("CROSS")) {
                    b = 7;
                }
                break;
            case 364489912:
                if (tag.equals("triggerSlack")) {
                    b = 8;
                }
                break;
            case 1301930599:
                if (tag.equals("viewTransitionOnCross")) {
                    b = 9;
                }
                break;
            case 1401391082:
                if (tag.equals("postLayout")) {
                    b = 10;
                }
                break;
            case 1535404999:
                if (tag.equals("triggerReceiver")) {
                    b = Ascii.VT;
                }
                break;
        }
        switch (b) {
            case 0:
                this.mPositiveCross = value.toString();
                break;
            case 1:
                this.mViewTransitionOnPositiveCross = toInt(value);
                break;
            case 2:
                this.mTriggerCollisionId = toInt(value);
                break;
            case 3:
                this.mTriggerID = toInt(value);
                break;
            case 4:
                this.mNegativeCross = value.toString();
                break;
            case 5:
                this.mTriggerCollisionView = (View) value;
                break;
            case 6:
                this.mViewTransitionOnNegativeCross = toInt(value);
                break;
            case 7:
                this.mCross = value.toString();
                break;
            case 8:
                this.mTriggerSlack = toFloat(value);
                break;
            case 9:
                this.mViewTransitionOnCross = toInt(value);
                break;
            case 10:
                this.mPostLayout = toBoolean(value);
                break;
            case 11:
                this.mTriggerReceiver = toInt(value);
                break;
        }
    }

    private void setUpRect(RectF rect, View child, boolean postLayout) {
        rect.top = child.getTop();
        rect.bottom = child.getBottom();
        rect.left = child.getLeft();
        rect.right = child.getRight();
        if (postLayout) {
            child.getMatrix().mapRect(rect);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0088  */
    /* JADX WARN: Code duplicated, block: B:41:0x009a  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:47:0x00af  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d0  */
    public void conditionallyFire(float pos, View child) {
        boolean z;
        boolean z2;
        float f;
        boolean z3;
        boolean z4;
        float f2;
        float f3;
        boolean z5;
        float f4;
        boolean z6 = true;
        boolean z7 = false;
        if (this.mTriggerCollisionId != UNSET) {
            if (this.mTriggerCollisionView == null) {
                this.mTriggerCollisionView = ((ViewGroup) child.getParent()).findViewById(this.mTriggerCollisionId);
            }
            setUpRect(this.mCollisionRect, this.mTriggerCollisionView, this.mPostLayout);
            setUpRect(this.mTargetRect, child, this.mPostLayout);
            boolean zIntersect = this.mCollisionRect.intersect(this.mTargetRect);
            boolean z8 = this.mFireCrossReset;
            if (zIntersect) {
                if (z8) {
                    this.mFireCrossReset = false;
                    z = true;
                } else {
                    z = false;
                }
                if (this.mFirePositiveReset) {
                    this.mFirePositiveReset = false;
                    z5 = true;
                } else {
                    z5 = false;
                }
                this.mFireNegativeReset = true;
            } else {
                if (z8) {
                    z = false;
                } else {
                    this.mFireCrossReset = true;
                    z = true;
                }
                if (this.mFireNegativeReset) {
                    this.mFireNegativeReset = false;
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.mFirePositiveReset = true;
                z7 = z3;
                z5 = false;
            }
        } else {
            boolean z9 = this.mFireCrossReset;
            float f5 = this.mFireThreshold;
            if (z9) {
                if ((pos - f5) * (this.mFireLastPos - f5) < 0.0f) {
                    this.mFireCrossReset = false;
                    z = true;
                }
                z2 = this.mFireNegativeReset;
                f = this.mFireThreshold;
                if (z2) {
                    f4 = pos - f;
                    if ((this.mFireLastPos - f) * f4 >= 0.0f && f4 < 0.0f) {
                        this.mFireNegativeReset = false;
                        z3 = true;
                    }
                    z4 = this.mFirePositiveReset;
                    f2 = this.mFireThreshold;
                    if (z4) {
                        f3 = pos - f2;
                        if ((this.mFireLastPos - f2) * f3 < 0.0f || f3 <= 0.0f) {
                            z6 = false;
                        } else {
                            this.mFirePositiveReset = false;
                        }
                        z7 = z3;
                        z5 = z6;
                    } else {
                        if (Math.abs(pos - f2) > this.mTriggerSlack) {
                            this.mFirePositiveReset = true;
                        }
                        z7 = z3;
                        z5 = false;
                    }
                } else if (Math.abs(pos - f) > this.mTriggerSlack) {
                    this.mFireNegativeReset = true;
                }
                z3 = false;
                z4 = this.mFirePositiveReset;
                f2 = this.mFireThreshold;
                if (z4) {
                    f3 = pos - f2;
                    if ((this.mFireLastPos - f2) * f3 < 0.0f) {
                        z6 = false;
                    } else {
                        z6 = false;
                    }
                    z7 = z3;
                    z5 = z6;
                } else {
                    if (Math.abs(pos - f2) > this.mTriggerSlack) {
                        this.mFirePositiveReset = true;
                    }
                    z7 = z3;
                    z5 = false;
                }
            } else if (Math.abs(pos - f5) > this.mTriggerSlack) {
                this.mFireCrossReset = true;
            }
            z = false;
            z2 = this.mFireNegativeReset;
            f = this.mFireThreshold;
            if (z2) {
                f4 = pos - f;
                if ((this.mFireLastPos - f) * f4 >= 0.0f) {
                }
                z4 = this.mFirePositiveReset;
                f2 = this.mFireThreshold;
                if (z4) {
                    f3 = pos - f2;
                    if ((this.mFireLastPos - f2) * f3 < 0.0f) {
                        z6 = false;
                    } else {
                        z6 = false;
                    }
                    z7 = z3;
                    z5 = z6;
                } else {
                    if (Math.abs(pos - f2) > this.mTriggerSlack) {
                        this.mFirePositiveReset = true;
                    }
                    z7 = z3;
                    z5 = false;
                }
            } else if (Math.abs(pos - f) > this.mTriggerSlack) {
                this.mFireNegativeReset = true;
            }
            z3 = false;
            z4 = this.mFirePositiveReset;
            f2 = this.mFireThreshold;
            if (z4) {
                f3 = pos - f2;
                if ((this.mFireLastPos - f2) * f3 < 0.0f) {
                    z6 = false;
                } else {
                    z6 = false;
                }
                z7 = z3;
                z5 = z6;
            } else {
                if (Math.abs(pos - f2) > this.mTriggerSlack) {
                    this.mFirePositiveReset = true;
                }
                z7 = z3;
                z5 = false;
            }
        }
        this.mFireLastPos = pos;
        if (z7 || z || z5) {
            ((MotionLayout) child.getParent()).fireTrigger(this.mTriggerID, z5, pos);
        }
        View viewFindViewById = this.mTriggerReceiver == UNSET ? child : ((MotionLayout) child.getParent()).findViewById(this.mTriggerReceiver);
        if (z7) {
            String str = this.mNegativeCross;
            if (str != null) {
                fire(str, viewFindViewById);
            }
            if (this.mViewTransitionOnNegativeCross != UNSET) {
                ((MotionLayout) child.getParent()).viewTransition(this.mViewTransitionOnNegativeCross, viewFindViewById);
            }
        }
        if (z5) {
            String str2 = this.mPositiveCross;
            if (str2 != null) {
                fire(str2, viewFindViewById);
            }
            if (this.mViewTransitionOnPositiveCross != UNSET) {
                ((MotionLayout) child.getParent()).viewTransition(this.mViewTransitionOnPositiveCross, viewFindViewById);
            }
        }
        if (z) {
            String str3 = this.mCross;
            if (str3 != null) {
                fire(str3, viewFindViewById);
            }
            if (this.mViewTransitionOnCross != UNSET) {
                ((MotionLayout) child.getParent()).viewTransition(this.mViewTransitionOnCross, viewFindViewById);
            }
        }
    }

    private void fire(String str, View call) {
        Method method;
        if (str == null) {
            return;
        }
        if (str.startsWith(".")) {
            fireCustom(str, call);
            return;
        }
        if (this.mMethodHashMap.containsKey(str)) {
            method = this.mMethodHashMap.get(str);
            if (method == null) {
                return;
            }
        } else {
            method = null;
        }
        if (method == null) {
            try {
                method = call.getClass().getMethod(str, null);
                this.mMethodHashMap.put(str, method);
            } catch (NoSuchMethodException unused) {
                this.mMethodHashMap.put(str, null);
                Log.e("KeyTrigger", "Could not find method \"" + str + "\"on class " + call.getClass().getSimpleName() + ServerSentEventKt.SPACE + Debug.getName(call));
                return;
            }
        }
        try {
            method.invoke(call, null);
        } catch (Exception unused2) {
            Log.e("KeyTrigger", "Exception in call \"" + this.mCross + "\"on class " + call.getClass().getSimpleName() + ServerSentEventKt.SPACE + Debug.getName(call));
        }
    }

    private void fireCustom(String str, View view) {
        boolean z = str.length() == 1;
        if (!z) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str2 : this.mCustomConstraints.keySet()) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            if (z || lowerCase.matches(str)) {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str2);
                if (constraintAttribute != null) {
                    constraintAttribute.applyCustom(view);
                }
            }
        }
    }

    private static class Loader {
        private static final int COLLISION = 9;
        private static final int CROSS = 4;
        private static final int FRAME_POS = 8;
        private static final int NEGATIVE_CROSS = 1;
        private static final int POSITIVE_CROSS = 2;
        private static final int POST_LAYOUT = 10;
        private static final int TARGET_ID = 7;
        private static final int TRIGGER_ID = 6;
        private static final int TRIGGER_RECEIVER = 11;
        private static final int TRIGGER_SLACK = 5;
        private static final int VT_CROSS = 12;
        private static final int VT_NEGATIVE_CROSS = 13;
        private static final int VT_POSITIVE_CROSS = 14;
        private static SparseIntArray mAttrMap;

        private Loader() {
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
            mAttrMap.append(R.styleable.KeyTrigger_onCross, 4);
            mAttrMap.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            mAttrMap.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            mAttrMap.append(R.styleable.KeyTrigger_motionTarget, 7);
            mAttrMap.append(R.styleable.KeyTrigger_triggerId, 6);
            mAttrMap.append(R.styleable.KeyTrigger_triggerSlack, 5);
            mAttrMap.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            mAttrMap.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            mAttrMap.append(R.styleable.KeyTrigger_triggerReceiver, 11);
            mAttrMap.append(R.styleable.KeyTrigger_viewTransitionOnCross, 12);
            mAttrMap.append(R.styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            mAttrMap.append(R.styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        public static void read(KeyTrigger c, TypedArray a2, Context context) {
            int indexCount = a2.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = a2.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        c.mNegativeCross = a2.getString(index);
                        break;
                    case 2:
                        c.mPositiveCross = a2.getString(index);
                        break;
                    case 3:
                    default:
                        Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
                        break;
                    case 4:
                        c.mCross = a2.getString(index);
                        break;
                    case 5:
                        c.mTriggerSlack = a2.getFloat(index, c.mTriggerSlack);
                        break;
                    case 6:
                        c.mTriggerID = a2.getResourceId(index, c.mTriggerID);
                        break;
                    case 7:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            c.mTargetId = a2.getResourceId(index, c.mTargetId);
                            if (c.mTargetId == -1) {
                                c.mTargetString = a2.getString(index);
                            }
                        } else if (a2.peekValue(index).type == 3) {
                            c.mTargetString = a2.getString(index);
                        } else {
                            c.mTargetId = a2.getResourceId(index, c.mTargetId);
                        }
                        break;
                    case 8:
                        c.mFramePosition = a2.getInteger(index, c.mFramePosition);
                        c.mFireThreshold = (c.mFramePosition + 0.5f) / 100.0f;
                        break;
                    case 9:
                        c.mTriggerCollisionId = a2.getResourceId(index, c.mTriggerCollisionId);
                        break;
                    case 10:
                        c.mPostLayout = a2.getBoolean(index, c.mPostLayout);
                        break;
                    case 11:
                        c.mTriggerReceiver = a2.getResourceId(index, c.mTriggerReceiver);
                        break;
                    case 12:
                        c.mViewTransitionOnCross = a2.getResourceId(index, c.mViewTransitionOnCross);
                        break;
                    case 13:
                        c.mViewTransitionOnNegativeCross = a2.getResourceId(index, c.mViewTransitionOnNegativeCross);
                        break;
                    case 14:
                        c.mViewTransitionOnPositiveCross = a2.getResourceId(index, c.mViewTransitionOnPositiveCross);
                        break;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key src) {
        super.copy(src);
        KeyTrigger keyTrigger = (KeyTrigger) src;
        this.mCurveFit = keyTrigger.mCurveFit;
        this.mCross = keyTrigger.mCross;
        this.mTriggerReceiver = keyTrigger.mTriggerReceiver;
        this.mNegativeCross = keyTrigger.mNegativeCross;
        this.mPositiveCross = keyTrigger.mPositiveCross;
        this.mTriggerID = keyTrigger.mTriggerID;
        this.mTriggerCollisionId = keyTrigger.mTriggerCollisionId;
        this.mTriggerCollisionView = keyTrigger.mTriggerCollisionView;
        this.mTriggerSlack = keyTrigger.mTriggerSlack;
        this.mFireCrossReset = keyTrigger.mFireCrossReset;
        this.mFireNegativeReset = keyTrigger.mFireNegativeReset;
        this.mFirePositiveReset = keyTrigger.mFirePositiveReset;
        this.mFireThreshold = keyTrigger.mFireThreshold;
        this.mFireLastPos = keyTrigger.mFireLastPos;
        this.mPostLayout = keyTrigger.mPostLayout;
        this.mCollisionRect = keyTrigger.mCollisionRect;
        this.mTargetRect = keyTrigger.mTargetRect;
        this.mMethodHashMap = keyTrigger.mMethodHashMap;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public Key mo10427clone() {
        return new KeyTrigger().copy(this);
    }
}
