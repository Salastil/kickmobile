package com.amazonaws.ivs.player;

import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.work.Data;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/* JADX INFO: loaded from: classes5.dex */
class GLManager {
    GLManager() {
    }

    static Result<GLException, Texture> createTexture(final int i) {
        final int[] iArr = new int[1];
        return check("Create Texture", new Supplier() { // from class: com.amazonaws.ivs.player.GLManager$$ExternalSyntheticLambda0
            @Override // com.amazonaws.ivs.player.Supplier
            public final Object get() {
                return GLManager.lambda$createTexture$0(iArr, i);
            }
        }, new Consumer() { // from class: com.amazonaws.ivs.player.GLManager$$ExternalSyntheticLambda1
            @Override // com.amazonaws.ivs.player.Consumer
            public final void accept(Object obj) {
                ((GLManager.Texture) obj).release();
            }
        });
    }

    static /* synthetic */ Texture lambda$createTexture$0(int[] iArr, int i) {
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(i, iArr[0]);
        GLES20.glTexParameterf(i, 10241, 9728.0f);
        GLES20.glTexParameterf(i, Data.MAX_DATA_BYTES, 9729.0f);
        GLES20.glTexParameterf(i, 10242, 33071.0f);
        GLES20.glTexParameterf(i, 10243, 33071.0f);
        GLES20.glBindTexture(i, -1);
        return new Texture(iArr[0], i);
    }

    static Result<GLException, Shader> createShader(int i) {
        String str;
        if (i != 36197) {
            str = "";
        } else {
            str = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 vTextureCoord;uniform samplerExternalOES sTexture;void main() {gl_FragColor = texture2D(sTexture, vTextureCoord).rgba;}";
        }
        final GLException gLException = new GLException();
        Result resultIfError = Shader.createShader(35633, "uniform mat4 uMVPMatrix;uniform mat4 uTexMatrix;attribute vec4 aPosition;attribute vec4 aTextureCoord;varying vec2 vTextureCoord;void main() {gl_Position = uMVPMatrix * aPosition;vTextureCoord = (uTexMatrix * aTextureCoord).xy;}").ifError(new Consumer() { // from class: com.amazonaws.ivs.player.GLManager$$ExternalSyntheticLambda2
            @Override // com.amazonaws.ivs.player.Consumer
            public final void accept(Object obj) {
                gLException.appendErrors((GLException) obj);
            }
        });
        Result resultIfError2 = Shader.createShader(35632, str).ifError(new Consumer() { // from class: com.amazonaws.ivs.player.GLManager$$ExternalSyntheticLambda2
            @Override // com.amazonaws.ivs.player.Consumer
            public final void accept(Object obj) {
                gLException.appendErrors((GLException) obj);
            }
        });
        if (!gLException.errors.isEmpty()) {
            return Result.error(gLException);
        }
        Result resultCreateShaderProgram = Shader.createShaderProgram(((Integer) resultIfError.getValue()).intValue(), ((Integer) resultIfError2.getValue()).intValue());
        if (resultIfError.isError()) {
            return Result.error((GLException) resultIfError.getError());
        }
        int iIntValue = ((Integer) resultCreateShaderProgram.getValue()).intValue();
        Result resultIfError3 = Shader.assignAttribLocation(iIntValue, "aPosition").ifError(new Consumer() { // from class: com.amazonaws.ivs.player.GLManager$$ExternalSyntheticLambda2
            @Override // com.amazonaws.ivs.player.Consumer
            public final void accept(Object obj) {
                gLException.appendErrors((GLException) obj);
            }
        });
        Result resultIfError4 = Shader.assignAttribLocation(iIntValue, "aTextureCoord").ifError(new Consumer() { // from class: com.amazonaws.ivs.player.GLManager$$ExternalSyntheticLambda2
            @Override // com.amazonaws.ivs.player.Consumer
            public final void accept(Object obj) {
                gLException.appendErrors((GLException) obj);
            }
        });
        Result resultIfError5 = Shader.assignUniformLocation(iIntValue, "uMVPMatrix").ifError(new Consumer() { // from class: com.amazonaws.ivs.player.GLManager$$ExternalSyntheticLambda2
            @Override // com.amazonaws.ivs.player.Consumer
            public final void accept(Object obj) {
                gLException.appendErrors((GLException) obj);
            }
        });
        Result resultIfError6 = Shader.assignUniformLocation(iIntValue, "uTexMatrix").ifError(new Consumer() { // from class: com.amazonaws.ivs.player.GLManager$$ExternalSyntheticLambda2
            @Override // com.amazonaws.ivs.player.Consumer
            public final void accept(Object obj) {
                gLException.appendErrors((GLException) obj);
            }
        });
        if (gLException.errors.isEmpty()) {
            return Result.value(new Shader(iIntValue, ((Integer) resultIfError3.getValue()).intValue(), ((Integer) resultIfError4.getValue()).intValue(), ((Integer) resultIfError5.getValue()).intValue(), ((Integer) resultIfError6.getValue()).intValue()));
        }
        return Result.error(gLException);
    }

    private static GLException checkInternal(String str) {
        GLError gLError = null;
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                break;
            }
            if (gLError == null) {
                gLError = new GLError(str);
            }
            gLError.appendErrorCode(iGlGetError);
        }
        if (gLError != null) {
            return new GLException(gLError);
        }
        return null;
    }

    static GLException check(String str, Runnable runnable) {
        runnable.run();
        return checkInternal(str);
    }

    static <V> Result<GLException, V> check(String str, Supplier<V> supplier, Consumer<V> consumer) {
        V v = supplier.get();
        GLException gLExceptionCheckInternal = checkInternal(str);
        if (gLExceptionCheckInternal != null) {
            if (consumer != null) {
                consumer.accept(v);
            }
            return Result.error(gLExceptionCheckInternal);
        }
        return Result.value(v);
    }

    static <V> Result<GLException, V> check(String str, Supplier<V> supplier, Consumer<V> consumer, Predicate<V> predicate) {
        V v = supplier.get();
        GLException gLExceptionCheckInternal = checkInternal(str);
        if (gLExceptionCheckInternal != null) {
            if (consumer != null) {
                consumer.accept(v);
            }
            return Result.error(gLExceptionCheckInternal);
        }
        if (!predicate.test(v)) {
            if (consumer != null) {
                consumer.accept(v);
            }
            return Result.error(new GLException(new GLError(str + " post condition failed")));
        }
        return Result.value(v);
    }

    static class Texture implements Releasable {
        static final int texture2DTarget = 3553;
        static final int textureExternalTarget = 36197;
        int id;
        long presentationTimestamp;
        final int targetType;
        float[] transform;

        void setPresentationTimestamp(long j) {
            this.presentationTimestamp = j;
        }

        private Texture(int i, int i2) {
            this.presentationTimestamp = 0L;
            this.id = i;
            this.targetType = i2;
            this.transform = new float[16];
        }

        @Override // com.amazonaws.ivs.player.Releasable
        public void release() {
            int i = this.id;
            if (i >= 0) {
                GLES20.glDeleteTextures(1, new int[]{i}, 0);
                this.id = -1;
            }
        }
    }

    static class Shader implements Releasable {
        private static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 vTextureCoord;uniform samplerExternalOES sTexture;void main() {gl_FragColor = texture2D(sTexture, vTextureCoord).rgba;}";
        private static final float[] IDENTITY_MATRIX;
        private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;uniform mat4 uTexMatrix;attribute vec4 aPosition;attribute vec4 aTextureCoord;varying vec2 vTextureCoord;void main() {gl_Position = uMVPMatrix * aPosition;vTextureCoord = (uTexMatrix * aTextureCoord).xy;}";
        private final int mMVPMatrixLocation;
        private final int mPositionLocation;
        private final int mProgramHandle;
        private final int mTexCoordLocation;
        private final int mTexMatrixLocation;

        static {
            float[] fArr = new float[16];
            IDENTITY_MATRIX = fArr;
            Matrix.setIdentityM(fArr, 0);
        }

        private Shader(int i, int i2, int i3, int i4, int i5) {
            this.mProgramHandle = i;
            this.mPositionLocation = i2;
            this.mTexCoordLocation = i3;
            this.mMVPMatrixLocation = i4;
            this.mTexMatrixLocation = i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Result<GLException, Integer> assignAttribLocation(final int i, final String str) {
            return GLManager.check("Assign attribute " + str, new Supplier() { // from class: com.amazonaws.ivs.player.GLManager$Shader$$ExternalSyntheticLambda9
                @Override // com.amazonaws.ivs.player.Supplier
                public final Object get() {
                    return Integer.valueOf(GLES20.glGetAttribLocation(i, str));
                }
            }, null, new Predicate() { // from class: com.amazonaws.ivs.player.GLManager$Shader$$ExternalSyntheticLambda10
                @Override // com.amazonaws.ivs.player.Predicate
                public final boolean test(Object obj) {
                    return GLManager.Shader.lambda$assignAttribLocation$1((Integer) obj);
                }
            });
        }

        static /* synthetic */ boolean lambda$assignAttribLocation$1(Integer num) {
            return num.intValue() >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Result<GLException, Integer> assignUniformLocation(final int i, final String str) {
            return GLManager.check("Assign uniform " + str, new Supplier() { // from class: com.amazonaws.ivs.player.GLManager$Shader$$ExternalSyntheticLambda7
                @Override // com.amazonaws.ivs.player.Supplier
                public final Object get() {
                    return Integer.valueOf(GLES20.glGetUniformLocation(i, str));
                }
            }, null, new Predicate() { // from class: com.amazonaws.ivs.player.GLManager$Shader$$ExternalSyntheticLambda8
                @Override // com.amazonaws.ivs.player.Predicate
                public final boolean test(Object obj) {
                    return GLManager.Shader.lambda$assignUniformLocation$3((Integer) obj);
                }
            });
        }

        static /* synthetic */ boolean lambda$assignUniformLocation$3(Integer num) {
            return num.intValue() >= 0;
        }

        GLException draw(final Texture texture) {
            return GLManager.check("Draw", new Runnable() { // from class: com.amazonaws.ivs.player.GLManager$Shader$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m11052lambda$draw$4$comamazonawsivsplayerGLManager$Shader(texture);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$draw$4$com-amazonaws-ivs-player-GLManager$Shader, reason: not valid java name */
        /* synthetic */ void m11052lambda$draw$4$comamazonawsivsplayerGLManager$Shader(Texture texture) {
            GLES20.glUseProgram(this.mProgramHandle);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(texture.targetType, texture.id);
            GLES20.glUniformMatrix4fv(this.mMVPMatrixLocation, 1, false, IDENTITY_MATRIX, 0);
            GLES20.glUniformMatrix4fv(this.mTexMatrixLocation, 1, false, texture.transform, 0);
            GLES20.glEnableVertexAttribArray(this.mPositionLocation);
            GLES20.glVertexAttribPointer(this.mPositionLocation, 2, 5126, false, 8, (Buffer) Drawable.POSITION_BUF);
            GLES20.glEnableVertexAttribArray(this.mTexCoordLocation);
            GLES20.glVertexAttribPointer(this.mTexCoordLocation, 2, 5126, false, 8, (Buffer) Drawable.TEXCOORD_BUF);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.mPositionLocation);
            GLES20.glDisableVertexAttribArray(this.mTexCoordLocation);
            GLES20.glBindTexture(texture.targetType, 0);
            GLES20.glUseProgram(0);
        }

        @Override // com.amazonaws.ivs.player.Releasable
        public void release() {
            GLES20.glDeleteProgram(this.mProgramHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Result<GLException, Integer> createShaderProgram(final int i, final int i2) {
            return GLManager.check("Create Shader Program", new Supplier() { // from class: com.amazonaws.ivs.player.GLManager$Shader$$ExternalSyntheticLambda0
                @Override // com.amazonaws.ivs.player.Supplier
                public final Object get() {
                    return GLManager.Shader.lambda$createShaderProgram$5(i, i2);
                }
            }, new Consumer() { // from class: com.amazonaws.ivs.player.GLManager$Shader$$ExternalSyntheticLambda2
                @Override // com.amazonaws.ivs.player.Consumer
                public final void accept(Object obj) {
                    GLES20.glDeleteProgram(((Integer) obj).intValue());
                }
            }, new Predicate() { // from class: com.amazonaws.ivs.player.GLManager$Shader$$ExternalSyntheticLambda3
                @Override // com.amazonaws.ivs.player.Predicate
                public final boolean test(Object obj) {
                    return GLManager.Shader.lambda$createShaderProgram$6((Integer) obj);
                }
            });
        }

        static /* synthetic */ Integer lambda$createShaderProgram$5(int i, int i2) {
            int iGlCreateProgram = GLES20.glCreateProgram();
            GLES20.glAttachShader(iGlCreateProgram, i);
            GLES20.glAttachShader(iGlCreateProgram, i2);
            GLES20.glLinkProgram(iGlCreateProgram);
            return Integer.valueOf(iGlCreateProgram);
        }

        static /* synthetic */ boolean lambda$createShaderProgram$6(Integer num) {
            if (num.intValue() == 0) {
                return false;
            }
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(num.intValue(), 35714, iArr, 0);
            return iArr[0] != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Result<GLException, Integer> createShader(final int i, final String str) {
            return GLManager.check("Create Vertex Shader", new Supplier() { // from class: com.amazonaws.ivs.player.GLManager$Shader$$ExternalSyntheticLambda4
                @Override // com.amazonaws.ivs.player.Supplier
                public final Object get() {
                    return GLManager.Shader.lambda$createShader$7(i, str);
                }
            }, new Consumer() { // from class: com.amazonaws.ivs.player.GLManager$Shader$$ExternalSyntheticLambda5
                @Override // com.amazonaws.ivs.player.Consumer
                public final void accept(Object obj) {
                    GLES20.glDeleteShader(((Integer) obj).intValue());
                }
            }, new Predicate() { // from class: com.amazonaws.ivs.player.GLManager$Shader$$ExternalSyntheticLambda6
                @Override // com.amazonaws.ivs.player.Predicate
                public final boolean test(Object obj) {
                    return GLManager.Shader.lambda$createShader$8((Integer) obj);
                }
            });
        }

        static /* synthetic */ Integer lambda$createShader$7(int i, String str) {
            int iGlCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
            return Integer.valueOf(iGlCreateShader);
        }

        static /* synthetic */ boolean lambda$createShader$8(Integer num) {
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(num.intValue(), 35713, iArr, 0);
            return iArr[0] != 0;
        }

        static class Drawable {
            static final IntBuffer INDEX_BUF;
            private static final int[] INDICES;
            private static final float[] POSITIONS;
            static final FloatBuffer POSITION_BUF;
            static final int POSITION_STRIDE = 8;
            private static final float[] TEXCOORDS;
            static final FloatBuffer TEXCOORD_BUF;
            static final int TEXCOORD_STRIDE = 8;
            static final int VERTEX_COUNT = 4;

            Drawable() {
            }

            static {
                float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
                POSITIONS = fArr;
                float[] fArr2 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
                TEXCOORDS = fArr2;
                int[] iArr = {0, 2, 3, 1, 0, 3};
                INDICES = iArr;
                POSITION_BUF = createFloatBuffer(fArr);
                TEXCOORD_BUF = createFloatBuffer(fArr2);
                INDEX_BUF = createIntBuffer(iArr);
            }

            public static FloatBuffer createFloatBuffer(float[] fArr) {
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
                byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
                FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
                floatBufferAsFloatBuffer.put(fArr);
                floatBufferAsFloatBuffer.rewind();
                return floatBufferAsFloatBuffer;
            }

            public static IntBuffer createIntBuffer(int[] iArr) {
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(iArr.length * 4);
                byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
                IntBuffer intBufferAsIntBuffer = byteBufferAllocateDirect.asIntBuffer();
                intBufferAsIntBuffer.put(iArr);
                intBufferAsIntBuffer.rewind();
                return intBufferAsIntBuffer;
            }
        }
    }
}
