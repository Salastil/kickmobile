package androidx.camera.video;

import android.content.ContentValues;
import android.content.Context;
import android.location.Location;
import android.media.MediaFormat;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Range;
import android.util.Rational;
import android.view.Surface;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.MutableStateObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.StateObservable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.CloseGuardHelper;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.utils.ArrayRingBuffer;
import androidx.camera.core.internal.utils.RingBuffer;
import androidx.camera.video.internal.DebugUtils;
import androidx.camera.video.internal.OutputStorage;
import androidx.camera.video.internal.OutputStorageImpl;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.audio.AudioSourceAccessException;
import androidx.camera.video.internal.config.AudioConfigUtil;
import androidx.camera.video.internal.config.AudioMimeInfo;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.BufferCopiedEncodedData;
import androidx.camera.video.internal.encoder.EncodeException;
import androidx.camera.video.internal.encoder.EncodedData;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderCallback;
import androidx.camera.video.internal.encoder.EncoderConfig;
import androidx.camera.video.internal.encoder.EncoderFactory;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.OutputConfig;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.encoder.VideoEncoderInfoImpl;
import androidx.camera.video.internal.muxer.Media3MuxerImpl;
import androidx.camera.video.internal.muxer.MediaMuxerImpl;
import androidx.camera.video.internal.muxer.Muxer;
import androidx.camera.video.internal.muxer.MuxerException;
import androidx.camera.video.internal.muxer.MuxerFactory;
import androidx.camera.video.internal.utils.OutputUtil;
import androidx.camera.video.internal.utils.StorageUtil;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class Recorder implements VideoOutput {
    private static final int AUDIO_CACHE_SIZE = 60;
    private static final Executor AUDIO_EXECUTOR;
    static final EncoderFactory DEFAULT_ENCODER_FACTORY;
    private static final MuxerFactory DEFAULT_MUXER_FACTORY;
    public static final QualitySelector DEFAULT_QUALITY_SELECTOR;
    private static final VideoEncoderInfo.Finder DEFAULT_VIDEO_ENCODER_INFO_FINDER;
    private static final String INSUFFICIENT_STORAGE_ERROR_MSG = "Insufficient storage space. The available storage (%d bytes) is below the required threshold of %d bytes.";
    private static final String MEDIA_COLUMN = "_data";
    private static final MediaSpec MEDIA_SPEC_DEFAULT;
    private static final int NOT_PENDING = 0;
    private static final OutputStorage.Factory OUTPUT_STORAGE_FACTORY_DEFAULT;
    private static final int PENDING = 1;
    private static final Exception PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE;
    private static final long REQUIRED_FREE_STORAGE_DEFAULT_BYTES = 52428800;
    private static final long REQUIRED_FREE_STORAGE_UNSET = -1;
    private static final long RETRY_SETUP_VIDEO_DELAY_MS = 1000;
    private static final int RETRY_SETUP_VIDEO_MAX_COUNT = 3;
    private static final long SOURCE_NON_STREAMING_TIMEOUT_MS = 1000;
    private static final String TAG = "Recorder";
    public static final int VIDEO_CAPABILITIES_SOURCE_CAMCORDER_PROFILE = 0;
    public static final int VIDEO_CAPABILITIES_SOURCE_CODEC_CAPABILITIES = 1;
    static final int VIDEO_RECORDING_TYPE_HIGH_SPEED = 2;
    static final int VIDEO_RECORDING_TYPE_REGULAR = 1;
    private static final VideoSpec VIDEO_SPEC_DEFAULT;
    static long sRetrySetupVideoDelayMs;
    static int sRetrySetupVideoMaxCount;
    private final EncoderFactory mAudioEncoderFactory;
    private final Executor mExecutor;
    private final MutableStateObservable<Boolean> mIsRecording;
    SurfaceRequest mLatestSurfaceRequest;
    final MutableStateObservable<MediaSpec> mMediaSpec;
    private final MuxerFactory mMuxerFactory;
    private final OutputStorage.Factory mOutputStorageFactory;
    private final long mRequiredFreeStorageBytes;
    final Executor mSequentialExecutor;
    private final MutableStateObservable<StreamInfo> mStreamInfo;
    private final Executor mUserProvidedExecutor;
    private final int mVideoCapabilitiesSource;
    private final EncoderFactory mVideoEncoderFactory;
    VideoEncoderSession mVideoEncoderSession;
    Timebase mVideoSourceTimebase;
    private static final Set<State> PENDING_STATES = Collections.unmodifiableSet(EnumSet.of(State.PENDING_RECORDING, State.PENDING_PAUSED));
    private static final Set<State> VALID_NON_PENDING_STATES_WHILE_PENDING = Collections.unmodifiableSet(EnumSet.of(State.CONFIGURING, State.IDLING, State.RESETTING, State.STOPPING, State.ERROR));
    private final Object mLock = new Object();
    private final MutableStateObservable<Range<Integer>> mVideoEncoderBitrateRange = MutableStateObservable.withInitialState(null);
    private State mState = State.CONFIGURING;
    private State mNonPendingState = null;
    int mStreamId = 0;
    RecordingRecord mActiveRecordingRecord = null;
    RecordingRecord mPendingRecordingRecord = null;
    private long mLastGeneratedRecordingId = 0;
    RecordingRecord mInProgressRecording = null;
    boolean mInProgressRecordingStopping = false;
    private SurfaceRequest.TransformationInfo mInProgressTransformationInfo = null;
    private SurfaceRequest.TransformationInfo mSourceTransformationInfo = null;
    private VideoValidatedEncoderProfilesProxy mResolvedEncoderProfiles = null;
    final List<ListenableFuture<Void>> mEncodingFutures = new ArrayList();
    Integer mAudioTrackIndex = null;
    Integer mVideoTrackIndex = null;
    Surface mLatestSurface = null;
    Surface mActiveSurface = null;
    Muxer mMuxer = null;
    AudioSource mAudioSource = null;
    Encoder mVideoEncoder = null;
    OutputConfig mVideoOutputConfig = null;
    Encoder mAudioEncoder = null;
    OutputConfig mAudioOutputConfig = null;
    AudioState mAudioState = AudioState.INITIALIZING;
    Uri mOutputUri = Uri.EMPTY;
    long mRecordingBytes = 0;
    long mRecordingAudioBytes = 0;
    long mRecordingDurationUs = 0;
    long mFirstRecordingVideoDataTimeUs = Long.MAX_VALUE;
    int mFirstRecordingVideoBitrate = 0;
    long mFirstRecordingAudioDataTimeUs = Long.MAX_VALUE;
    long mPreviousRecordingVideoDataTimeUs = Long.MAX_VALUE;
    long mPreviousRecordingAudioDataTimeUs = Long.MAX_VALUE;
    long mFileSizeLimitInBytes = 0;
    long mDurationLimitUs = 0;
    int mRecordingStopError = 1;
    Throwable mRecordingStopErrorCause = null;
    EncodedData mPendingFirstVideoData = null;
    final RingBuffer<EncodedData> mPendingAudioRingBuffer = new ArrayRingBuffer(60);
    Throwable mAudioErrorCause = null;
    boolean mIsAudioSourceSilenced = false;
    VideoOutput.SourceState mSourceState = VideoOutput.SourceState.INACTIVE;
    ScheduledFuture<?> mSourceNonStreamingTimeout = null;
    private boolean mNeedsResetBeforeNextStart = false;
    private VideoEncoderConfig mVideoEncoderConfig = null;
    VideoEncoderSession mVideoEncoderSessionToRelease = null;
    double mAudioAmplitude = 0.0d;
    private boolean mShouldSendResumeEvent = false;
    private SetupVideoTask mSetupVideoTask = null;
    private OutputStorage mOutputStorage = null;
    private long mAvailableBytesAboveRequired = Long.MAX_VALUE;
    private boolean mHasGlProcessing = false;

    enum AudioState {
        INITIALIZING,
        IDLING,
        DISABLED,
        ENABLED,
        ERROR_ENCODER,
        ERROR_SOURCE
    }

    enum State {
        CONFIGURING,
        PENDING_RECORDING,
        PENDING_PAUSED,
        IDLING,
        RECORDING,
        PAUSED,
        STOPPING,
        RESETTING,
        ERROR
    }

    static {
        QualitySelector qualitySelectorFromOrderedList = QualitySelector.fromOrderedList(Arrays.asList(Quality.FHD, Quality.HD, Quality.SD), FallbackStrategy.higherQualityOrLowerThan(Quality.FHD));
        DEFAULT_QUALITY_SELECTOR = qualitySelectorFromOrderedList;
        VideoSpec videoSpecBuild = VideoSpec.builder().setQualitySelector(qualitySelectorFromOrderedList).setAspectRatio(-1).build();
        VIDEO_SPEC_DEFAULT = videoSpecBuild;
        MEDIA_SPEC_DEFAULT = MediaSpec.builder().setOutputFormat(-1).setVideoSpec(videoSpecBuild).build();
        PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE = new RuntimeException("The video frame producer became inactive before any data was received.");
        DEFAULT_ENCODER_FACTORY = new EncoderFactory() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda8
            @Override // androidx.camera.video.internal.encoder.EncoderFactory
            public final Encoder createEncoder(Executor executor, EncoderConfig encoderConfig, int i) {
                return new EncoderImpl(executor, encoderConfig, i);
            }
        };
        DEFAULT_VIDEO_ENCODER_INFO_FINDER = VideoEncoderInfoImpl.FINDER;
        DEFAULT_MUXER_FACTORY = new MuxerFactory() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda9
            @Override // androidx.camera.video.internal.muxer.MuxerFactory
            public final Muxer create(int i) {
                return Recorder.lambda$static$0(i);
            }
        };
        OUTPUT_STORAGE_FACTORY_DEFAULT = new OutputStorage.Factory() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda10
            @Override // androidx.camera.video.internal.OutputStorage.Factory
            public final OutputStorage create(OutputOptions outputOptions) {
                return new OutputStorageImpl(outputOptions);
            }
        };
        AUDIO_EXECUTOR = CameraXExecutors.newSequentialExecutor(CameraXExecutors.ioExecutor());
        sRetrySetupVideoMaxCount = 3;
        sRetrySetupVideoDelayMs = 1000L;
    }

    static /* synthetic */ Muxer lambda$static$0(int i) {
        if (i == 0 || i == 2) {
            Logger.d(TAG, "Create Media3MuxerImpl");
            return new Media3MuxerImpl();
        }
        Logger.d(TAG, "Create MediaMuxerImpl");
        return new MediaMuxerImpl();
    }

    Recorder(Executor executor, MediaSpec mediaSpec, int i, EncoderFactory encoderFactory, EncoderFactory encoderFactory2, MuxerFactory muxerFactory, OutputStorage.Factory factory, long j) {
        this.mUserProvidedExecutor = executor;
        executor = executor == null ? CameraXExecutors.ioExecutor() : executor;
        this.mExecutor = executor;
        Executor executorNewSequentialExecutor = CameraXExecutors.newSequentialExecutor(executor);
        this.mSequentialExecutor = executorNewSequentialExecutor;
        this.mMediaSpec = MutableStateObservable.withInitialState(composeRecorderMediaSpec(mediaSpec));
        this.mVideoCapabilitiesSource = i;
        this.mStreamInfo = MutableStateObservable.withInitialState(StreamInfo.of(this.mStreamId, internalStateToStreamState(this.mState)));
        this.mIsRecording = MutableStateObservable.withInitialState(false);
        this.mVideoEncoderFactory = encoderFactory;
        this.mAudioEncoderFactory = encoderFactory2;
        this.mMuxerFactory = muxerFactory;
        this.mOutputStorageFactory = factory;
        this.mVideoEncoderSession = new VideoEncoderSession(encoderFactory, executorNewSequentialExecutor, executor);
        j = j == -1 ? REQUIRED_FREE_STORAGE_DEFAULT_BYTES : j;
        this.mRequiredFreeStorageBytes = j;
        Logger.d(TAG, "mRequiredFreeStorageBytes = " + StorageUtil.formatSize(j));
    }

    @Override // androidx.camera.video.VideoOutput
    public void onSurfaceRequested(SurfaceRequest surfaceRequest) {
        onSurfaceRequested(surfaceRequest, Timebase.UPTIME, false);
    }

    @Override // androidx.camera.video.VideoOutput
    public void onSurfaceRequested(final SurfaceRequest surfaceRequest, final Timebase timebase, final boolean z) {
        synchronized (this.mLock) {
            Logger.d(TAG, "Surface is requested in state: " + this.mState + ", Current surface: " + this.mStreamId);
            if (this.mState == State.ERROR) {
                setState(State.CONFIGURING);
            }
        }
        this.mSequentialExecutor.execute(new Runnable() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1172lambda$onSurfaceRequested$1$androidxcameravideoRecorder(surfaceRequest, timebase, z);
            }
        });
    }

    @Override // androidx.camera.video.VideoOutput
    public Observable<MediaSpec> getMediaSpec() {
        return this.mMediaSpec;
    }

    @Override // androidx.camera.video.VideoOutput
    public Observable<StreamInfo> getStreamInfo() {
        return this.mStreamInfo;
    }

    @Override // androidx.camera.video.VideoOutput
    public Observable<Boolean> isSourceStreamRequired() {
        return this.mIsRecording;
    }

    @Override // androidx.camera.video.VideoOutput
    public void onSourceStateChanged(final VideoOutput.SourceState sourceState) {
        this.mSequentialExecutor.execute(new Runnable() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1171lambda$onSourceStateChanged$2$androidxcameravideoRecorder(sourceState);
            }
        });
    }

    @Override // androidx.camera.video.VideoOutput
    public VideoCapabilities getMediaCapabilities(CameraInfo cameraInfo, int i) {
        return getVideoCapabilitiesInternal(i == 1 ? 2 : 1, cameraInfo, this.mVideoCapabilitiesSource, ((MediaSpec) getObservableData(this.mMediaSpec)).getVideoSpec().getMimeType());
    }

    public PendingRecording prepareRecording(Context context, FileOutputOptions fileOutputOptions) {
        return prepareRecordingInternal(context, fileOutputOptions);
    }

    public PendingRecording prepareRecording(Context context, FileDescriptorOutputOptions fileDescriptorOutputOptions) {
        if (Build.VERSION.SDK_INT < 26) {
            throw new UnsupportedOperationException("File descriptors as output destinations are not supported on pre-Android O (API 26) devices.");
        }
        return prepareRecordingInternal(context, fileDescriptorOutputOptions);
    }

    public PendingRecording prepareRecording(Context context, MediaStoreOutputOptions mediaStoreOutputOptions) {
        return prepareRecordingInternal(context, mediaStoreOutputOptions);
    }

    private PendingRecording prepareRecordingInternal(Context context, OutputOptions outputOptions) {
        Preconditions.checkNotNull(outputOptions, "The OutputOptions cannot be null.");
        return new PendingRecording(context, this, outputOptions);
    }

    public QualitySelector getQualitySelector() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getVideoSpec().getQualitySelector();
    }

    @Override // androidx.camera.video.VideoOutput
    public boolean isQualitySelectorDefault() {
        return getQualitySelector() == DEFAULT_QUALITY_SELECTOR;
    }

    public int getVideoCapabilitiesSource() {
        return this.mVideoCapabilitiesSource;
    }

    public int getAudioSource() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getAudioSpec().getSource();
    }

    public Executor getExecutor() {
        return this.mUserProvidedExecutor;
    }

    public int getTargetVideoEncodingBitRate() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getVideoSpec().getBitrate();
    }

    public Observable<Range<Integer>> getVideoEncoderBitrateRange() {
        return this.mVideoEncoderBitrateRange;
    }

    public int getVideoEncodingFrameRate() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getVideoSpec().getEncodeFrameRate();
    }

    public void setVideoEncodingFrameRate(final int i) {
        Preconditions.checkArgument(i >= 1, "frameRate must be greater than 0.");
        MutableStateObservable<MediaSpec> mutableStateObservable = this.mMediaSpec;
        mutableStateObservable.setState(((MediaSpec) getObservableData(mutableStateObservable)).toBuilder().configureVideo(new Consumer() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda4
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ((VideoSpec.Builder) obj).setEncodeFrameRate(i);
            }
        }).build());
    }

    public int getAspectRatio() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getVideoSpec().getAspectRatio();
    }

    Recording start(PendingRecording pendingRecording) {
        long j;
        RecordingRecord recordingRecord;
        int i;
        RecordingRecord recordingRecord2;
        Preconditions.checkNotNull(pendingRecording, "The given PendingRecording cannot be null.");
        synchronized (this.mLock) {
            j = this.mLastGeneratedRecordingId + 1;
            this.mLastGeneratedRecordingId = j;
            recordingRecord = null;
            i = 0;
            switch (this.mState) {
                case CONFIGURING:
                case IDLING:
                case STOPPING:
                case RESETTING:
                case ERROR:
                    if (this.mState == State.IDLING) {
                        Preconditions.checkState(this.mActiveRecordingRecord == null && this.mPendingRecordingRecord == null, "Expected recorder to be idle but a recording is either pending or in progress.");
                    }
                    try {
                        RecordingRecord recordingRecordFrom = RecordingRecord.from(pendingRecording, j);
                        recordingRecordFrom.initializeRecording(pendingRecording.getApplicationContext(), this.mMuxerFactory);
                        this.mPendingRecordingRecord = recordingRecordFrom;
                        if (this.mState == State.IDLING) {
                            setState(State.PENDING_RECORDING);
                            this.mSequentialExecutor.execute(new Runnable() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda12
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.tryServicePendingRecording();
                                }
                            });
                        } else if (this.mState == State.ERROR) {
                            setState(State.PENDING_RECORDING);
                            this.mSequentialExecutor.execute(new Runnable() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda13
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.m1176lambda$start$4$androidxcameravideoRecorder();
                                }
                            });
                        } else {
                            setState(State.PENDING_RECORDING);
                        }
                        e = null;
                    } catch (IOException e) {
                        e = e;
                        i = 5;
                    }
                    break;
                case PENDING_RECORDING:
                case PENDING_PAUSED:
                    recordingRecord2 = (RecordingRecord) Preconditions.checkNotNull(this.mPendingRecordingRecord);
                    recordingRecord = recordingRecord2;
                    e = null;
                    break;
                case RECORDING:
                case PAUSED:
                    recordingRecord2 = this.mActiveRecordingRecord;
                    recordingRecord = recordingRecord2;
                    e = null;
                    break;
                default:
                    e = null;
                    break;
            }
        }
        if (recordingRecord != null) {
            throw new IllegalStateException("A recording is already in progress. Previous recordings must be stopped before a new recording can be started.");
        }
        if (i != 0) {
            Logger.e(TAG, "Recording was started when the Recorder had encountered error " + e);
            finalizePendingRecording(RecordingRecord.from(pendingRecording, j), i, e);
            return Recording.createFinalizedFrom(pendingRecording, j);
        }
        return Recording.from(pendingRecording, j);
    }

    /* JADX INFO: renamed from: lambda$start$4$androidx-camera-video-Recorder, reason: not valid java name */
    /* synthetic */ void m1176lambda$start$4$androidxcameravideoRecorder() {
        SurfaceRequest surfaceRequest = this.mLatestSurfaceRequest;
        if (surfaceRequest == null) {
            throw new AssertionError("surface request is required to retry initialization.");
        }
        configureInternal(surfaceRequest, this.mVideoSourceTimebase, false);
    }

    void pause(Recording recording) {
        synchronized (this.mLock) {
            if (!isSameRecording(recording, this.mPendingRecordingRecord) && !isSameRecording(recording, this.mActiveRecordingRecord)) {
                Logger.d(TAG, "pause() called on a recording that is no longer active: " + recording.getOutputOptions());
                return;
            }
            int iOrdinal = this.mState.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    setState(State.PENDING_PAUSED);
                } else if (iOrdinal != 3) {
                    if (iOrdinal == 4) {
                        setState(State.PAUSED);
                        final RecordingRecord recordingRecord = this.mActiveRecordingRecord;
                        this.mSequentialExecutor.execute(new Runnable() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda17
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.m1173lambda$pause$5$androidxcameravideoRecorder(recordingRecord);
                            }
                        });
                    }
                }
                return;
            }
            throw new IllegalStateException("Called pause() from invalid state: " + this.mState);
        }
    }

    void resume(Recording recording) {
        synchronized (this.mLock) {
            if (!isSameRecording(recording, this.mPendingRecordingRecord) && !isSameRecording(recording, this.mActiveRecordingRecord)) {
                Logger.d(TAG, "resume() called on a recording that is no longer active: " + recording.getOutputOptions());
                return;
            }
            int iOrdinal = this.mState.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 5) {
                    setState(State.RECORDING);
                    final RecordingRecord recordingRecord = this.mActiveRecordingRecord;
                    this.mSequentialExecutor.execute(new Runnable() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m1174lambda$resume$6$androidxcameravideoRecorder(recordingRecord);
                        }
                    });
                } else if (iOrdinal == 2) {
                    setState(State.PENDING_RECORDING);
                } else if (iOrdinal != 3) {
                }
                return;
            }
            throw new IllegalStateException("Called resume() from invalid state: " + this.mState);
        }
    }

    void stop(Recording recording, final int i, final Throwable th) {
        synchronized (this.mLock) {
            if (!isSameRecording(recording, this.mPendingRecordingRecord) && !isSameRecording(recording, this.mActiveRecordingRecord)) {
                Logger.d(TAG, "stop() called on a recording that is no longer active: " + recording.getOutputOptions());
                return;
            }
            RecordingRecord recordingRecord = null;
            switch (this.mState) {
                case CONFIGURING:
                case IDLING:
                    throw new IllegalStateException("Calling stop() while idling or initializing is invalid.");
                case PENDING_RECORDING:
                case PENDING_PAUSED:
                    Preconditions.checkState(isSameRecording(recording, this.mPendingRecordingRecord));
                    RecordingRecord recordingRecord2 = this.mPendingRecordingRecord;
                    this.mPendingRecordingRecord = null;
                    restoreNonPendingState();
                    recordingRecord = recordingRecord2;
                    break;
                case RECORDING:
                case PAUSED:
                    setState(State.STOPPING);
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    final long jNanoTime = System.nanoTime() / 1000;
                    final RecordingRecord recordingRecord3 = this.mActiveRecordingRecord;
                    this.mSequentialExecutor.execute(new Runnable() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m1177lambda$stop$7$androidxcameravideoRecorder(recordingRecord3, jNanoTime, i, th);
                        }
                    });
                    break;
                case STOPPING:
                case RESETTING:
                    Preconditions.checkState(isSameRecording(recording, this.mActiveRecordingRecord));
                    break;
            }
            if (recordingRecord != null) {
                if (i == 10) {
                    Logger.e(TAG, "Recording was stopped due to recording being garbage collected before any valid data has been produced.");
                }
                finalizePendingRecording(recordingRecord, 8, new RuntimeException("Recording was stopped before any data could be produced.", th));
            }
        }
    }

    void mute(Recording recording, final boolean z) {
        synchronized (this.mLock) {
            if (!isSameRecording(recording, this.mPendingRecordingRecord) && !isSameRecording(recording, this.mActiveRecordingRecord)) {
                Logger.d(TAG, "mute() called on a recording that is no longer active: " + recording.getOutputOptions());
            } else {
                final RecordingRecord recordingRecord = isSameRecording(recording, this.mPendingRecordingRecord) ? this.mPendingRecordingRecord : this.mActiveRecordingRecord;
                this.mSequentialExecutor.execute(new Runnable() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m1170lambda$mute$8$androidxcameravideoRecorder(recordingRecord, z);
                    }
                });
            }
        }
    }

    private void finalizePendingRecording(RecordingRecord recordingRecord, int i, Throwable th) {
        recordingRecord.finalizeRecording(Uri.EMPTY);
        recordingRecord.updateVideoRecordEvent(VideoRecordEvent.finalizeWithError(recordingRecord.getOutputOptions(), RecordingStats.of(0L, 0L, AudioStats.of(1, this.mAudioErrorCause, 0.0d, 0L)), OutputResults.of(Uri.EMPTY), i, th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onSurfaceRequestedInternal, reason: merged with bridge method [inline-methods] */
    public void m1172lambda$onSurfaceRequested$1$androidxcameravideoRecorder(SurfaceRequest surfaceRequest, Timebase timebase, boolean z) {
        SurfaceRequest surfaceRequest2 = this.mLatestSurfaceRequest;
        if (surfaceRequest2 != null && !surfaceRequest2.isServiced()) {
            this.mLatestSurfaceRequest.willNotProvideSurface();
        }
        this.mHasGlProcessing = z;
        this.mLatestSurfaceRequest = surfaceRequest;
        this.mVideoSourceTimebase = timebase;
        configureInternal(surfaceRequest, timebase, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: onSourceStateChangedInternal, reason: merged with bridge method [inline-methods] */
    public void m1171lambda$onSourceStateChanged$2$androidxcameravideoRecorder(VideoOutput.SourceState sourceState) {
        ScheduledFuture<?> scheduledFuture;
        Encoder encoder;
        VideoOutput.SourceState sourceState2 = this.mSourceState;
        this.mSourceState = sourceState;
        if (sourceState2 != sourceState) {
            Logger.d(TAG, "Video source has transitioned to state: " + sourceState);
            if (sourceState == VideoOutput.SourceState.INACTIVE) {
                if (this.mActiveSurface == null) {
                    SetupVideoTask setupVideoTask = this.mSetupVideoTask;
                    if (setupVideoTask != null) {
                        setupVideoTask.cancelFailedRetry();
                        this.mSetupVideoTask = null;
                    }
                    requestReset(4, null, false);
                    return;
                }
                this.mNeedsResetBeforeNextStart = true;
                RecordingRecord recordingRecord = this.mInProgressRecording;
                if (recordingRecord == null || recordingRecord.isPersistent()) {
                    return;
                }
                onInProgressRecordingInternalError(this.mInProgressRecording, 4, null);
                return;
            }
            if (sourceState != VideoOutput.SourceState.ACTIVE_NON_STREAMING || (scheduledFuture = this.mSourceNonStreamingTimeout) == null || !scheduledFuture.cancel(false) || (encoder = this.mVideoEncoder) == null) {
                return;
            }
            notifyEncoderSourceStopped(encoder);
            return;
        }
        Logger.d(TAG, "Video source transitions to the same state: " + sourceState);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    void requestReset(int i, Throwable th, boolean z) {
        boolean z2;
        boolean z3;
        synchronized (this.mLock) {
            z2 = true;
            z3 = false;
            switch (this.mState) {
                case CONFIGURING:
                case IDLING:
                case ERROR:
                    break;
                case PENDING_RECORDING:
                case PENDING_PAUSED:
                    updateNonPendingState(State.RESETTING);
                    break;
                case RECORDING:
                case PAUSED:
                    Preconditions.checkState(this.mInProgressRecording != null, "In-progress recording shouldn't be null when in state " + this.mState);
                    if (this.mActiveRecordingRecord != this.mInProgressRecording) {
                        throw new AssertionError("In-progress recording does not match the active recording. Unable to reset encoder.");
                    }
                    if (!isPersistentRecordingInProgress()) {
                        setState(State.RESETTING);
                        z3 = true;
                        z2 = false;
                    }
                    break;
                    break;
                case STOPPING:
                    setState(State.RESETTING);
                    z2 = false;
                    break;
                case RESETTING:
                default:
                    z2 = false;
                    break;
            }
        }
        if (!z2) {
            if (z3) {
                m1177lambda$stop$7$androidxcameravideoRecorder(this.mInProgressRecording, -1L, i, th);
            }
        } else if (z) {
            resetVideo();
        } else {
            reset();
        }
    }

    private void configureInternal(SurfaceRequest surfaceRequest, Timebase timebase, boolean z) {
        if (surfaceRequest.isServiced()) {
            Logger.w(TAG, "Ignore the SurfaceRequest since it is already served.");
            return;
        }
        surfaceRequest.setTransformationInfoListener(this.mSequentialExecutor, new SurfaceRequest.TransformationInfoListener() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda15
            @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
            public final void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
                this.f$0.m1169lambda$configureInternal$9$androidxcameravideoRecorder(transformationInfo);
            }
        });
        this.mResolvedEncoderProfiles = getEncoderProfilesResolver(surfaceRequest.getCamera().getCameraInfo(), surfaceRequest.getSessionType()).findNearestHigherSupportedEncoderProfilesFor(surfaceRequest.getResolution(), surfaceRequest.getDynamicRange());
        Logger.d(TAG, "mResolvedEncoderProfiles = " + this.mResolvedEncoderProfiles);
        SetupVideoTask setupVideoTask = this.mSetupVideoTask;
        if (setupVideoTask != null) {
            setupVideoTask.cancelFailedRetry();
        }
        SetupVideoTask setupVideoTask2 = new SetupVideoTask(surfaceRequest, timebase, this.mHasGlProcessing, z ? sRetrySetupVideoMaxCount : 0);
        this.mSetupVideoTask = setupVideoTask2;
        setupVideoTask2.start();
    }

    /* JADX INFO: renamed from: lambda$configureInternal$9$androidx-camera-video-Recorder, reason: not valid java name */
    /* synthetic */ void m1169lambda$configureInternal$9$androidxcameravideoRecorder(SurfaceRequest.TransformationInfo transformationInfo) {
        this.mSourceTransformationInfo = transformationInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SetupVideoTask {
        private final int mMaxRetryCount;
        private final SurfaceRequest mSurfaceRequest;
        private final Timebase mTimebase;
        private boolean mIsFailedRetryCanceled = false;
        private int mRetryCount = 0;
        private ScheduledFuture<?> mRetryFuture = null;

        static /* synthetic */ int access$608(SetupVideoTask setupVideoTask) {
            int i = setupVideoTask.mRetryCount;
            setupVideoTask.mRetryCount = i + 1;
            return i;
        }

        SetupVideoTask(SurfaceRequest surfaceRequest, Timebase timebase, boolean z, int i) {
            this.mSurfaceRequest = surfaceRequest;
            this.mTimebase = timebase;
            Recorder.this.mHasGlProcessing = z;
            this.mMaxRetryCount = i;
        }

        void start() {
            setupVideo(this.mSurfaceRequest, this.mTimebase);
        }

        void cancelFailedRetry() {
            if (this.mIsFailedRetryCanceled) {
                return;
            }
            this.mIsFailedRetryCanceled = true;
            ScheduledFuture<?> scheduledFuture = this.mRetryFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                this.mRetryFuture = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setupVideo(final SurfaceRequest surfaceRequest, final Timebase timebase) {
            Recorder.this.safeToCloseVideoEncoder().addListener(new Runnable() { // from class: androidx.camera.video.Recorder$SetupVideoTask$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1183xdf7f9b96(surfaceRequest, timebase);
                }
            }, Recorder.this.mSequentialExecutor);
        }

        /* JADX INFO: renamed from: lambda$setupVideo$0$androidx-camera-video-Recorder$SetupVideoTask, reason: not valid java name */
        /* synthetic */ void m1183xdf7f9b96(SurfaceRequest surfaceRequest, Timebase timebase) {
            if (surfaceRequest.isServiced() || (Recorder.this.mVideoEncoderSession.isConfiguredSurfaceRequest(surfaceRequest) && !Recorder.this.isPersistentRecordingInProgress())) {
                Logger.w(Recorder.TAG, "Ignore the SurfaceRequest " + surfaceRequest + " isServiced: " + surfaceRequest.isServiced() + " VideoEncoderSession: " + Recorder.this.mVideoEncoderSession + " has been configured with a persistent in-progress recording.");
                return;
            }
            VideoEncoderSession videoEncoderSession = new VideoEncoderSession(Recorder.this.mVideoEncoderFactory, Recorder.this.mSequentialExecutor, Recorder.this.mExecutor);
            Recorder recorder = Recorder.this;
            MediaSpec mediaSpec = (MediaSpec) recorder.getObservableData(recorder.mMediaSpec);
            DynamicRange dynamicRange = surfaceRequest.getDynamicRange();
            VideoEncoderConfig videoEncoderConfigWorkaroundDataSpaceIfRequired = VideoConfigUtil.workaroundDataSpaceIfRequired(VideoConfigUtil.resolveVideoEncoderConfig(VideoConfigUtil.resolveVideoMimeInfo(mediaSpec, dynamicRange, Recorder.this.mResolvedEncoderProfiles), timebase, mediaSpec.getVideoSpec(), surfaceRequest.getResolution(), dynamicRange, surfaceRequest.getExpectedFrameRate()), Recorder.this.mHasGlProcessing);
            Recorder.this.mVideoEncoderConfig = videoEncoderConfigWorkaroundDataSpaceIfRequired;
            ListenableFuture<Encoder> listenableFutureConfigure = videoEncoderSession.configure(surfaceRequest, videoEncoderConfigWorkaroundDataSpaceIfRequired);
            Recorder.this.mVideoEncoderSession = videoEncoderSession;
            Futures.addCallback(listenableFutureConfigure, new AnonymousClass1(videoEncoderSession), Recorder.this.mSequentialExecutor);
        }

        /* JADX INFO: renamed from: androidx.camera.video.Recorder$SetupVideoTask$1, reason: invalid class name */
        class AnonymousClass1 implements FutureCallback<Encoder> {
            final /* synthetic */ VideoEncoderSession val$videoEncoderSession;

            AnonymousClass1(VideoEncoderSession videoEncoderSession) {
                this.val$videoEncoderSession = videoEncoderSession;
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Encoder encoder) {
                Logger.d(Recorder.TAG, "VideoEncoder is created. " + encoder);
                if (encoder == null) {
                    return;
                }
                Preconditions.checkState(Recorder.this.mVideoEncoderSession == this.val$videoEncoderSession);
                Preconditions.checkState(Recorder.this.mVideoEncoder == null);
                Recorder.this.onVideoEncoderReady(this.val$videoEncoderSession);
                Recorder.this.onConfigured();
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                Logger.w(Recorder.TAG, "VideoEncoder Setup error: " + th, th);
                int i = SetupVideoTask.this.mRetryCount;
                int i2 = SetupVideoTask.this.mMaxRetryCount;
                SetupVideoTask setupVideoTask = SetupVideoTask.this;
                if (i < i2) {
                    SetupVideoTask.access$608(setupVideoTask);
                    SetupVideoTask.this.mRetryFuture = Recorder.scheduleTask(new Runnable() { // from class: androidx.camera.video.Recorder$SetupVideoTask$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m1184xdc553cf6();
                        }
                    }, Recorder.this.mSequentialExecutor, Recorder.sRetrySetupVideoDelayMs, TimeUnit.MILLISECONDS);
                    return;
                }
                Recorder.this.onEncoderSetupError(th);
            }

            /* JADX INFO: renamed from: lambda$onFailure$0$androidx-camera-video-Recorder$SetupVideoTask$1, reason: not valid java name */
            /* synthetic */ void m1184xdc553cf6() {
                if (SetupVideoTask.this.mIsFailedRetryCanceled) {
                    return;
                }
                Logger.d(Recorder.TAG, "Retry setupVideo #" + SetupVideoTask.this.mRetryCount);
                SetupVideoTask setupVideoTask = SetupVideoTask.this;
                setupVideoTask.setupVideo(setupVideoTask.mSurfaceRequest, SetupVideoTask.this.mTimebase);
            }
        }
    }

    boolean isPersistentRecordingInProgress() {
        RecordingRecord recordingRecord = this.mInProgressRecording;
        return recordingRecord != null && recordingRecord.isPersistent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ListenableFuture<Void> safeToCloseVideoEncoder() {
        Logger.d(TAG, "Try to safely release video encoder: " + this.mVideoEncoder);
        return this.mVideoEncoderSession.signalTermination();
    }

    void onVideoEncoderReady(final VideoEncoderSession videoEncoderSession) {
        Encoder encoder = (Encoder) Preconditions.checkNotNull(videoEncoderSession.getVideoEncoder());
        this.mVideoEncoder = encoder;
        this.mVideoEncoderBitrateRange.setState(((VideoEncoderInfo) encoder.getEncoderInfo()).getSupportedBitrateRange());
        this.mFirstRecordingVideoBitrate = this.mVideoEncoder.getConfiguredBitrate();
        Surface activeSurface = videoEncoderSession.getActiveSurface();
        this.mActiveSurface = activeSurface;
        setLatestSurface(activeSurface);
        Futures.addCallback(videoEncoderSession.getReadyToReleaseFuture(), new FutureCallback<Encoder>() { // from class: androidx.camera.video.Recorder.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Encoder encoder2) {
                Logger.d(Recorder.TAG, "VideoEncoder can be released: " + encoder2);
                if (encoder2 == null) {
                    return;
                }
                if (Recorder.this.mSourceNonStreamingTimeout != null && Recorder.this.mSourceNonStreamingTimeout.cancel(false) && Recorder.this.mVideoEncoder != null && Recorder.this.mVideoEncoder == encoder2) {
                    Recorder.notifyEncoderSourceStopped(Recorder.this.mVideoEncoder);
                }
                Recorder.this.mVideoEncoderSessionToRelease = videoEncoderSession;
                Recorder.this.setLatestSurface(null);
                Recorder recorder = Recorder.this;
                recorder.requestReset(4, null, recorder.isPersistentRecordingInProgress());
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                Logger.d(Recorder.TAG, "Error in ReadyToReleaseFuture: " + th);
            }
        }, this.mSequentialExecutor);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0050  */
    /* JADX WARN: Code duplicated, block: B:20:0x0054 A[Catch: all -> 0x00b4, TryCatch #0 {, blocks: (B:4:0x0005, B:5:0x000e, B:27:0x007c, B:7:0x0013, B:8:0x001c, B:9:0x0023, B:12:0x0027, B:13:0x0035, B:14:0x0048, B:17:0x004c, B:20:0x0054, B:22:0x005a, B:23:0x0066, B:24:0x0072), top: B:44:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x005a A[Catch: all -> 0x00b4, TryCatch #0 {, blocks: (B:4:0x0005, B:5:0x000e, B:27:0x007c, B:7:0x0013, B:8:0x001c, B:9:0x0023, B:12:0x0027, B:13:0x0035, B:14:0x0048, B:17:0x004c, B:20:0x0054, B:22:0x005a, B:23:0x0066, B:24:0x0072), top: B:44:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0066 A[Catch: all -> 0x00b4, TryCatch #0 {, blocks: (B:4:0x0005, B:5:0x000e, B:27:0x007c, B:7:0x0013, B:8:0x001c, B:9:0x0023, B:12:0x0027, B:13:0x0035, B:14:0x0048, B:17:0x004c, B:20:0x0054, B:22:0x005a, B:23:0x0066, B:24:0x0072), top: B:44:0x0005 }] */
    void onConfigured() {
        RecordingRecord recordingRecordMakePendingRecordingActiveLocked;
        boolean z;
        Exception exc;
        int i;
        int i2;
        RecordingRecord recordingRecord;
        synchronized (this.mLock) {
            recordingRecordMakePendingRecordingActiveLocked = null;
            switch (this.mState) {
                case CONFIGURING:
                    setState(State.IDLING);
                    recordingRecord = null;
                    exc = null;
                    z = false;
                    i = 0;
                    i2 = i;
                    break;
                case PENDING_RECORDING:
                    z = false;
                    if (this.mActiveRecordingRecord != null) {
                        recordingRecord = null;
                        exc = null;
                        i = 0;
                        i2 = i;
                    } else if (this.mSourceState == VideoOutput.SourceState.INACTIVE) {
                        recordingRecord = this.mPendingRecordingRecord;
                        this.mPendingRecordingRecord = null;
                        restoreNonPendingState();
                        exc = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE;
                        i = 4;
                        i2 = 0;
                    } else {
                        exc = null;
                        i = 0;
                        i2 = 0;
                        recordingRecordMakePendingRecordingActiveLocked = makePendingRecordingActiveLocked(this.mState);
                        recordingRecord = null;
                    }
                    break;
                case PENDING_PAUSED:
                    z = true;
                    if (this.mActiveRecordingRecord != null) {
                        recordingRecord = null;
                        exc = null;
                        i = 0;
                        i2 = i;
                    } else if (this.mSourceState == VideoOutput.SourceState.INACTIVE) {
                        recordingRecord = this.mPendingRecordingRecord;
                        this.mPendingRecordingRecord = null;
                        restoreNonPendingState();
                        exc = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE;
                        i = 4;
                        i2 = 0;
                    } else {
                        exc = null;
                        i = 0;
                        i2 = 0;
                        recordingRecordMakePendingRecordingActiveLocked = makePendingRecordingActiveLocked(this.mState);
                        recordingRecord = null;
                    }
                    break;
                case IDLING:
                case RESETTING:
                    throw new AssertionError("Incorrectly invoke onConfigured() in state " + this.mState);
                case RECORDING:
                    z = false;
                    Preconditions.checkState(isPersistentRecordingInProgress(), "Unexpectedly invoke onConfigured() when there's a non-persistent in-progress recording");
                    i2 = 1;
                    recordingRecord = null;
                    exc = null;
                    i = 0;
                    break;
                case PAUSED:
                    z = true;
                    Preconditions.checkState(isPersistentRecordingInProgress(), "Unexpectedly invoke onConfigured() when there's a non-persistent in-progress recording");
                    i2 = 1;
                    recordingRecord = null;
                    exc = null;
                    i = 0;
                    break;
                case STOPPING:
                    throw new AssertionError("Unexpectedly invoke onConfigured() in a STOPPING state when it's not waiting for a new surface.");
                case ERROR:
                    Logger.e(TAG, "onConfigured() was invoked when the Recorder had encountered error");
                    recordingRecord = null;
                    exc = null;
                    z = false;
                    i = 0;
                    i2 = i;
                    break;
                default:
                    recordingRecord = null;
                    exc = null;
                    z = false;
                    i = 0;
                    i2 = i;
                    break;
            }
        }
        if (i2 == 0) {
            if (recordingRecordMakePendingRecordingActiveLocked != null) {
                startRecording(recordingRecordMakePendingRecordingActiveLocked, z);
                return;
            } else {
                if (recordingRecord != null) {
                    finalizePendingRecording(recordingRecord, i, exc);
                    return;
                }
                return;
            }
        }
        updateEncoderCallbacks(this.mInProgressRecording, true);
        this.mVideoEncoder.start();
        if (this.mShouldSendResumeEvent) {
            RecordingRecord recordingRecord2 = this.mInProgressRecording;
            recordingRecord2.updateVideoRecordEvent(VideoRecordEvent.resume(recordingRecord2.getOutputOptions(), getInProgressRecordingStats()));
            this.mShouldSendResumeEvent = false;
        }
        if (z) {
            this.mVideoEncoder.pause();
        }
    }

    private MediaSpec composeRecorderMediaSpec(MediaSpec mediaSpec) {
        MediaSpec.Builder builder = mediaSpec.toBuilder();
        if (mediaSpec.getVideoSpec().getAspectRatio() == -1) {
            builder.configureVideo(new Consumer() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda11
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((VideoSpec.Builder) obj).setAspectRatio(Recorder.VIDEO_SPEC_DEFAULT.getAspectRatio());
                }
            });
        }
        return builder.build();
    }

    private static boolean isSameRecording(Recording recording, RecordingRecord recordingRecord) {
        return recordingRecord != null && recording.getRecordingId() == recordingRecord.getRecordingId();
    }

    private void setupAudio(RecordingRecord recordingRecord) throws InvalidConfigException, AudioSourceAccessException {
        MediaSpec mediaSpec = (MediaSpec) getObservableData(this.mMediaSpec);
        AudioMimeInfo audioMimeInfoResolveAudioMimeInfo = AudioConfigUtil.resolveAudioMimeInfo(mediaSpec, this.mResolvedEncoderProfiles);
        Timebase timebase = Timebase.UPTIME;
        VideoEncoderConfig videoEncoderConfig = (VideoEncoderConfig) Preconditions.checkNotNull(this.mVideoEncoderConfig);
        AudioSettings audioSettingsResolveAudioSettings = AudioConfigUtil.resolveAudioSettings(audioMimeInfoResolveAudioMimeInfo, mediaSpec.getAudioSpec(), videoEncoderConfig.isSlowMotion() ? new Rational(videoEncoderConfig.getCaptureFrameRate(), videoEncoderConfig.getEncodeFrameRate()) : null);
        if (this.mAudioSource != null) {
            releaseCurrentAudioSource();
        }
        AudioSource audioSource = setupAudioSource(recordingRecord, audioSettingsResolveAudioSettings);
        this.mAudioSource = audioSource;
        Logger.d(TAG, String.format("Set up new audio source: 0x%x", Integer.valueOf(audioSource.hashCode())));
        Encoder encoderCreateEncoder = this.mAudioEncoderFactory.createEncoder(this.mExecutor, AudioConfigUtil.resolveAudioEncoderConfig(audioMimeInfoResolveAudioMimeInfo, timebase, audioSettingsResolveAudioSettings, mediaSpec.getAudioSpec()), ((SurfaceRequest) Preconditions.checkNotNull(this.mLatestSurfaceRequest)).getSessionType());
        this.mAudioEncoder = encoderCreateEncoder;
        Encoder.EncoderInput input = encoderCreateEncoder.getInput();
        if (!(input instanceof Encoder.ByteBufferInput)) {
            throw new AssertionError("The EncoderInput of audio isn't a ByteBufferInput.");
        }
        this.mAudioSource.setBufferProvider((Encoder.ByteBufferInput) input);
    }

    private AudioSource setupAudioSource(RecordingRecord recordingRecord, AudioSettings audioSettings) throws AudioSourceAccessException {
        return recordingRecord.performOneTimeAudioSourceCreation(audioSettings);
    }

    private void releaseCurrentAudioSource() {
        final AudioSource audioSource = this.mAudioSource;
        if (audioSource == null) {
            throw new AssertionError("Cannot release null audio source.");
        }
        this.mAudioSource = null;
        Logger.d(TAG, String.format("Releasing audio source: 0x%x", Integer.valueOf(audioSource.hashCode())));
        Futures.addCallback(audioSource.release(), new FutureCallback<Void>() { // from class: androidx.camera.video.Recorder.2
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void r1) {
                Logger.d(Recorder.TAG, String.format("Released audio source successfully: 0x%x", Integer.valueOf(audioSource.hashCode())));
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                Logger.d(Recorder.TAG, String.format("An error occurred while attempting to release audio source: 0x%x", Integer.valueOf(audioSource.hashCode())));
            }
        }, CameraXExecutors.directExecutor());
    }

    void onEncoderSetupError(Throwable th) {
        RecordingRecord recordingRecord;
        synchronized (this.mLock) {
            recordingRecord = null;
            switch (this.mState) {
                case PENDING_RECORDING:
                case PENDING_PAUSED:
                    RecordingRecord recordingRecord2 = this.mPendingRecordingRecord;
                    this.mPendingRecordingRecord = null;
                    recordingRecord = recordingRecord2;
                case CONFIGURING:
                    setStreamId(-1);
                    setState(State.ERROR);
                    break;
                case IDLING:
                case RECORDING:
                case PAUSED:
                case STOPPING:
                case RESETTING:
                    throw new AssertionError("Encountered encoder setup error while in unexpected state " + this.mState + ": " + th);
                default:
                    break;
            }
        }
        if (recordingRecord != null) {
            finalizePendingRecording(recordingRecord, 7, th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x00e1 A[Catch: all -> 0x01b8, TRY_LEAVE, TryCatch #2 {all -> 0x01b8, blocks: (B:14:0x0020, B:15:0x0032, B:17:0x0038, B:18:0x0044, B:23:0x0052, B:28:0x0075, B:30:0x0084, B:32:0x009d, B:33:0x00a6, B:35:0x00aa, B:36:0x00ad, B:39:0x00b6, B:42:0x00c0, B:44:0x00ca, B:50:0x00e1, B:52:0x00ef, B:58:0x0102, B:60:0x0138, B:61:0x0168, B:62:0x0170, B:63:0x0179, B:65:0x017f, B:71:0x0190, B:75:0x01a0, B:55:0x00f8, B:47:0x00d7, B:31:0x0095, B:79:0x01a7, B:83:0x01af), top: B:102:0x0020, inners: #0, #1, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0138 A[Catch: MuxerException -> 0x018f, all -> 0x01b8, TryCatch #3 {MuxerException -> 0x018f, blocks: (B:58:0x0102, B:60:0x0138, B:61:0x0168), top: B:103:0x0102, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x017f A[Catch: all -> 0x01b8, LOOP:1: B:63:0x0179->B:65:0x017f, LOOP_END, TRY_LEAVE, TryCatch #2 {all -> 0x01b8, blocks: (B:14:0x0020, B:15:0x0032, B:17:0x0038, B:18:0x0044, B:23:0x0052, B:28:0x0075, B:30:0x0084, B:32:0x009d, B:33:0x00a6, B:35:0x00aa, B:36:0x00ad, B:39:0x00b6, B:42:0x00c0, B:44:0x00ca, B:50:0x00e1, B:52:0x00ef, B:58:0x0102, B:60:0x0138, B:61:0x0168, B:62:0x0170, B:63:0x0179, B:65:0x017f, B:71:0x0190, B:75:0x01a0, B:55:0x00f8, B:47:0x00d7, B:31:0x0095, B:79:0x01a7, B:83:0x01af), top: B:102:0x0020, inners: #0, #1, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x018b  */
    /* JADX WARN: Instruction removed from duplicated block: B:60:0x0138, please report this as an issue */
    void setupAndStartMuxer(RecordingRecord recordingRecord) {
        int iOutputFormatToMuxerFormat;
        Location location;
        VideoEncoderConfig videoEncoderConfig;
        Iterator<EncodedData> it;
        if (this.mMuxer != null) {
            throw new AssertionError("Unable to set up muxer when one already exists.");
        }
        if (isAudioEnabled() && this.mPendingAudioRingBuffer.isEmpty()) {
            throw new AssertionError("Audio is enabled but no audio sample is ready. Cannot start muxer.");
        }
        EncodedData encodedData = this.mPendingFirstVideoData;
        if (encodedData == null) {
            throw new AssertionError("Muxer cannot be started without an encoded video frame.");
        }
        try {
            this.mPendingFirstVideoData = null;
            List<EncodedData> audioDataToWriteAndClearCache = getAudioDataToWriteAndClearCache(encodedData.getPresentationTimeUs());
            long size = encodedData.size();
            Iterator<EncodedData> it2 = audioDataToWriteAndClearCache.iterator();
            while (it2.hasNext()) {
                size += it2.next().size();
            }
            long j = this.mFileSizeLimitInBytes;
            if (j != 0 && size > j) {
                Logger.d(TAG, String.format("Initial data exceeds file size limit %d > %d", Long.valueOf(size), Long.valueOf(this.mFileSizeLimitInBytes)));
                onInProgressRecordingInternalError(recordingRecord, 2, null);
                if (encodedData != null) {
                    encodedData.close();
                    return;
                }
                return;
            }
            int i = 3;
            try {
                MediaSpec mediaSpec = (MediaSpec) getObservableData(this.mMediaSpec);
                if (mediaSpec.getOutputFormat() == -1) {
                    iOutputFormatToMuxerFormat = supportedMuxerFormatOrDefaultFrom(this.mResolvedEncoderProfiles, MediaSpec.outputFormatToMuxerFormat(MEDIA_SPEC_DEFAULT.getOutputFormat()));
                } else {
                    iOutputFormatToMuxerFormat = MediaSpec.outputFormatToMuxerFormat(mediaSpec.getOutputFormat());
                }
                Muxer muxerPerformOneTimeMuxerCreation = recordingRecord.performOneTimeMuxerCreation(iOutputFormatToMuxerFormat, new Consumer() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda18
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        this.f$0.m1175lambda$setupAndStartMuxer$11$androidxcameravideoRecorder((Uri) obj);
                    }
                });
                SurfaceRequest.TransformationInfo transformationInfo = this.mSourceTransformationInfo;
                if (transformationInfo != null) {
                    setInProgressTransformationInfo(transformationInfo);
                    try {
                        muxerPerformOneTimeMuxerCreation.setOrientationDegrees(transformationInfo.getRotationDegrees());
                        location = recordingRecord.getOutputOptions().getLocation();
                        if (location != null) {
                            try {
                                muxerPerformOneTimeMuxerCreation.setLocation(location.getLatitude(), location.getLongitude());
                                videoEncoderConfig = (VideoEncoderConfig) Preconditions.checkNotNull(this.mVideoEncoderConfig);
                                if (videoEncoderConfig.isSlowMotion()) {
                                    try {
                                        muxerPerformOneTimeMuxerCreation.setCaptureFps(videoEncoderConfig.getCaptureFrameRate());
                                        try {
                                            Logger.d(TAG, "Muxer.addTrack() for video " + this.mVideoOutputConfig.getMediaFormat());
                                            this.mVideoTrackIndex = Integer.valueOf(muxerPerformOneTimeMuxerCreation.addTrack((MediaFormat) Preconditions.checkNotNull(this.mVideoOutputConfig.getMediaFormat())));
                                            if (isAudioEnabled()) {
                                                Logger.d(TAG, "Muxer.addTrack() for audio " + this.mAudioOutputConfig.getMediaFormat());
                                                this.mAudioTrackIndex = Integer.valueOf(muxerPerformOneTimeMuxerCreation.addTrack((MediaFormat) Preconditions.checkNotNull(this.mAudioOutputConfig.getMediaFormat())));
                                            }
                                            Logger.d(TAG, "Muxer.start()");
                                            muxerPerformOneTimeMuxerCreation.start();
                                            this.mMuxer = muxerPerformOneTimeMuxerCreation;
                                            writeVideoData(encodedData, recordingRecord);
                                            it = audioDataToWriteAndClearCache.iterator();
                                            while (it.hasNext()) {
                                                writeAudioData(it.next(), recordingRecord);
                                            }
                                            if (encodedData != null) {
                                                encodedData.close();
                                                return;
                                            }
                                            return;
                                        } catch (MuxerException e) {
                                            Logger.w(TAG, "Failed to setup and start muxer", e);
                                            muxerPerformOneTimeMuxerCreation.release();
                                            if (!hasInsufficientStorageOrException(e)) {
                                                i = 1;
                                            }
                                            onInProgressRecordingInternalError(recordingRecord, i, e);
                                            if (encodedData == null) {
                                                return;
                                            }
                                        }
                                    } catch (IllegalArgumentException e2) {
                                        muxerPerformOneTimeMuxerCreation.release();
                                        onInProgressRecordingInternalError(recordingRecord, 5, e2);
                                        if (encodedData == null) {
                                            return;
                                        }
                                    }
                                } else {
                                    Logger.d(TAG, "Muxer.addTrack() for video " + this.mVideoOutputConfig.getMediaFormat());
                                    this.mVideoTrackIndex = Integer.valueOf(muxerPerformOneTimeMuxerCreation.addTrack((MediaFormat) Preconditions.checkNotNull(this.mVideoOutputConfig.getMediaFormat())));
                                    if (isAudioEnabled()) {
                                        Logger.d(TAG, "Muxer.addTrack() for audio " + this.mAudioOutputConfig.getMediaFormat());
                                        this.mAudioTrackIndex = Integer.valueOf(muxerPerformOneTimeMuxerCreation.addTrack((MediaFormat) Preconditions.checkNotNull(this.mAudioOutputConfig.getMediaFormat())));
                                    }
                                    Logger.d(TAG, "Muxer.start()");
                                    muxerPerformOneTimeMuxerCreation.start();
                                    this.mMuxer = muxerPerformOneTimeMuxerCreation;
                                    writeVideoData(encodedData, recordingRecord);
                                    it = audioDataToWriteAndClearCache.iterator();
                                    while (it.hasNext()) {
                                        writeAudioData(it.next(), recordingRecord);
                                    }
                                    if (encodedData != null) {
                                        encodedData.close();
                                        return;
                                    }
                                    return;
                                }
                            } catch (IllegalArgumentException e3) {
                                muxerPerformOneTimeMuxerCreation.release();
                                onInProgressRecordingInternalError(recordingRecord, 5, e3);
                                if (encodedData == null) {
                                    return;
                                }
                            }
                        } else {
                            videoEncoderConfig = (VideoEncoderConfig) Preconditions.checkNotNull(this.mVideoEncoderConfig);
                            if (videoEncoderConfig.isSlowMotion()) {
                                muxerPerformOneTimeMuxerCreation.setCaptureFps(videoEncoderConfig.getCaptureFrameRate());
                                Logger.d(TAG, "Muxer.addTrack() for video " + this.mVideoOutputConfig.getMediaFormat());
                                this.mVideoTrackIndex = Integer.valueOf(muxerPerformOneTimeMuxerCreation.addTrack((MediaFormat) Preconditions.checkNotNull(this.mVideoOutputConfig.getMediaFormat())));
                                if (isAudioEnabled()) {
                                    Logger.d(TAG, "Muxer.addTrack() for audio " + this.mAudioOutputConfig.getMediaFormat());
                                    this.mAudioTrackIndex = Integer.valueOf(muxerPerformOneTimeMuxerCreation.addTrack((MediaFormat) Preconditions.checkNotNull(this.mAudioOutputConfig.getMediaFormat())));
                                }
                                Logger.d(TAG, "Muxer.start()");
                                muxerPerformOneTimeMuxerCreation.start();
                                this.mMuxer = muxerPerformOneTimeMuxerCreation;
                                writeVideoData(encodedData, recordingRecord);
                                it = audioDataToWriteAndClearCache.iterator();
                                while (it.hasNext()) {
                                    writeAudioData(it.next(), recordingRecord);
                                }
                                if (encodedData != null) {
                                    encodedData.close();
                                    return;
                                }
                                return;
                            }
                            Logger.d(TAG, "Muxer.addTrack() for video " + this.mVideoOutputConfig.getMediaFormat());
                            this.mVideoTrackIndex = Integer.valueOf(muxerPerformOneTimeMuxerCreation.addTrack((MediaFormat) Preconditions.checkNotNull(this.mVideoOutputConfig.getMediaFormat())));
                            if (isAudioEnabled()) {
                                Logger.d(TAG, "Muxer.addTrack() for audio " + this.mAudioOutputConfig.getMediaFormat());
                                this.mAudioTrackIndex = Integer.valueOf(muxerPerformOneTimeMuxerCreation.addTrack((MediaFormat) Preconditions.checkNotNull(this.mAudioOutputConfig.getMediaFormat())));
                            }
                            Logger.d(TAG, "Muxer.start()");
                            muxerPerformOneTimeMuxerCreation.start();
                            this.mMuxer = muxerPerformOneTimeMuxerCreation;
                            writeVideoData(encodedData, recordingRecord);
                            it = audioDataToWriteAndClearCache.iterator();
                            while (it.hasNext()) {
                                writeAudioData(it.next(), recordingRecord);
                            }
                            if (encodedData != null) {
                                encodedData.close();
                                return;
                            }
                            return;
                        }
                    } catch (IllegalArgumentException e4) {
                        muxerPerformOneTimeMuxerCreation.release();
                        onInProgressRecordingInternalError(recordingRecord, 5, e4);
                        if (encodedData == null) {
                            return;
                        }
                    }
                } else {
                    location = recordingRecord.getOutputOptions().getLocation();
                    if (location != null) {
                        muxerPerformOneTimeMuxerCreation.setLocation(location.getLatitude(), location.getLongitude());
                        videoEncoderConfig = (VideoEncoderConfig) Preconditions.checkNotNull(this.mVideoEncoderConfig);
                        if (videoEncoderConfig.isSlowMotion()) {
                            muxerPerformOneTimeMuxerCreation.setCaptureFps(videoEncoderConfig.getCaptureFrameRate());
                            Logger.d(TAG, "Muxer.addTrack() for video " + this.mVideoOutputConfig.getMediaFormat());
                            this.mVideoTrackIndex = Integer.valueOf(muxerPerformOneTimeMuxerCreation.addTrack((MediaFormat) Preconditions.checkNotNull(this.mVideoOutputConfig.getMediaFormat())));
                            if (isAudioEnabled()) {
                                Logger.d(TAG, "Muxer.addTrack() for audio " + this.mAudioOutputConfig.getMediaFormat());
                                this.mAudioTrackIndex = Integer.valueOf(muxerPerformOneTimeMuxerCreation.addTrack((MediaFormat) Preconditions.checkNotNull(this.mAudioOutputConfig.getMediaFormat())));
                            }
                            Logger.d(TAG, "Muxer.start()");
                            muxerPerformOneTimeMuxerCreation.start();
                            this.mMuxer = muxerPerformOneTimeMuxerCreation;
                            writeVideoData(encodedData, recordingRecord);
                            it = audioDataToWriteAndClearCache.iterator();
                            while (it.hasNext()) {
                                writeAudioData(it.next(), recordingRecord);
                            }
                            if (encodedData != null) {
                                encodedData.close();
                                return;
                            }
                            return;
                        }
                        Logger.d(TAG, "Muxer.addTrack() for video " + this.mVideoOutputConfig.getMediaFormat());
                        this.mVideoTrackIndex = Integer.valueOf(muxerPerformOneTimeMuxerCreation.addTrack((MediaFormat) Preconditions.checkNotNull(this.mVideoOutputConfig.getMediaFormat())));
                        if (isAudioEnabled()) {
                            Logger.d(TAG, "Muxer.addTrack() for audio " + this.mAudioOutputConfig.getMediaFormat());
                            this.mAudioTrackIndex = Integer.valueOf(muxerPerformOneTimeMuxerCreation.addTrack((MediaFormat) Preconditions.checkNotNull(this.mAudioOutputConfig.getMediaFormat())));
                        }
                        Logger.d(TAG, "Muxer.start()");
                        muxerPerformOneTimeMuxerCreation.start();
                        this.mMuxer = muxerPerformOneTimeMuxerCreation;
                        writeVideoData(encodedData, recordingRecord);
                        it = audioDataToWriteAndClearCache.iterator();
                        while (it.hasNext()) {
                            writeAudioData(it.next(), recordingRecord);
                        }
                        if (encodedData != null) {
                            encodedData.close();
                            return;
                        }
                        return;
                    }
                    videoEncoderConfig = (VideoEncoderConfig) Preconditions.checkNotNull(this.mVideoEncoderConfig);
                    if (videoEncoderConfig.isSlowMotion()) {
                        muxerPerformOneTimeMuxerCreation.setCaptureFps(videoEncoderConfig.getCaptureFrameRate());
                        Logger.d(TAG, "Muxer.addTrack() for video " + this.mVideoOutputConfig.getMediaFormat());
                        this.mVideoTrackIndex = Integer.valueOf(muxerPerformOneTimeMuxerCreation.addTrack((MediaFormat) Preconditions.checkNotNull(this.mVideoOutputConfig.getMediaFormat())));
                        if (isAudioEnabled()) {
                            Logger.d(TAG, "Muxer.addTrack() for audio " + this.mAudioOutputConfig.getMediaFormat());
                            this.mAudioTrackIndex = Integer.valueOf(muxerPerformOneTimeMuxerCreation.addTrack((MediaFormat) Preconditions.checkNotNull(this.mAudioOutputConfig.getMediaFormat())));
                        }
                        Logger.d(TAG, "Muxer.start()");
                        muxerPerformOneTimeMuxerCreation.start();
                        this.mMuxer = muxerPerformOneTimeMuxerCreation;
                        writeVideoData(encodedData, recordingRecord);
                        it = audioDataToWriteAndClearCache.iterator();
                        while (it.hasNext()) {
                            writeAudioData(it.next(), recordingRecord);
                        }
                        if (encodedData != null) {
                            encodedData.close();
                            return;
                        }
                        return;
                    }
                    Logger.d(TAG, "Muxer.addTrack() for video " + this.mVideoOutputConfig.getMediaFormat());
                    this.mVideoTrackIndex = Integer.valueOf(muxerPerformOneTimeMuxerCreation.addTrack((MediaFormat) Preconditions.checkNotNull(this.mVideoOutputConfig.getMediaFormat())));
                    if (isAudioEnabled()) {
                        Logger.d(TAG, "Muxer.addTrack() for audio " + this.mAudioOutputConfig.getMediaFormat());
                        this.mAudioTrackIndex = Integer.valueOf(muxerPerformOneTimeMuxerCreation.addTrack((MediaFormat) Preconditions.checkNotNull(this.mAudioOutputConfig.getMediaFormat())));
                    }
                    Logger.d(TAG, "Muxer.start()");
                    muxerPerformOneTimeMuxerCreation.start();
                    this.mMuxer = muxerPerformOneTimeMuxerCreation;
                    writeVideoData(encodedData, recordingRecord);
                    it = audioDataToWriteAndClearCache.iterator();
                    while (it.hasNext()) {
                        writeAudioData(it.next(), recordingRecord);
                    }
                    if (encodedData != null) {
                        encodedData.close();
                        return;
                    }
                    return;
                }
            } catch (IOException e5) {
                if (!hasInsufficientStorageOrException(e5)) {
                    i = 5;
                }
                onInProgressRecordingInternalError(recordingRecord, i, e5);
                if (encodedData == null) {
                    return;
                }
            }
            encodedData.close();
        } catch (Throwable th) {
            if (encodedData != null) {
                try {
                    encodedData.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: lambda$setupAndStartMuxer$11$androidx-camera-video-Recorder, reason: not valid java name */
    /* synthetic */ void m1175lambda$setupAndStartMuxer$11$androidxcameravideoRecorder(Uri uri) {
        this.mOutputUri = uri;
    }

    private List<EncodedData> getAudioDataToWriteAndClearCache(long j) {
        ArrayList arrayList = new ArrayList();
        while (!this.mPendingAudioRingBuffer.isEmpty()) {
            EncodedData encodedDataDequeue = this.mPendingAudioRingBuffer.dequeue();
            if (encodedDataDequeue.getPresentationTimeUs() >= j) {
                arrayList.add(encodedDataDequeue);
            }
        }
        return arrayList;
    }

    private void startInternal(RecordingRecord recordingRecord) {
        AudioState audioState;
        if (this.mInProgressRecording != null) {
            throw new AssertionError("Attempted to start a new recording while another was in progress.");
        }
        this.mInProgressRecording = recordingRecord;
        OutputStorage outputStorageCreate = this.mOutputStorageFactory.create(recordingRecord.getOutputOptions());
        this.mOutputStorage = outputStorageCreate;
        long availableBytes = outputStorageCreate.getAvailableBytes();
        Logger.d(TAG, "availableBytes = " + StorageUtil.formatSize(availableBytes));
        if (hasInsufficientStorage(availableBytes)) {
            finalizeInProgressRecording(3, new IOException(String.format(INSUFFICIENT_STORAGE_ERROR_MSG, Long.valueOf(availableBytes), Long.valueOf(this.mRequiredFreeStorageBytes))));
            return;
        }
        this.mAvailableBytesAboveRequired = availableBytes - this.mRequiredFreeStorageBytes;
        if (recordingRecord.getOutputOptions().getFileSizeLimit() > 0) {
            this.mFileSizeLimitInBytes = Math.round(recordingRecord.getOutputOptions().getFileSizeLimit() * 0.95d);
            Logger.d(TAG, "File size limit in bytes: " + this.mFileSizeLimitInBytes);
        } else {
            this.mFileSizeLimitInBytes = 0L;
        }
        if (recordingRecord.getOutputOptions().getDurationLimitMillis() > 0) {
            this.mDurationLimitUs = TimeUnit.MILLISECONDS.toMicros(recordingRecord.getOutputOptions().getDurationLimitMillis());
            Logger.d(TAG, "Duration limit in microseconds: " + this.mDurationLimitUs);
        } else {
            this.mDurationLimitUs = 0L;
        }
        int iOrdinal = this.mAudioState.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                setAudioState(recordingRecord.hasAudioEnabled() ? AudioState.ENABLED : AudioState.DISABLED);
            } else if (iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 4 || iOrdinal == 5) {
                throw new AssertionError("Incorrectly invoke startInternal in audio state " + this.mAudioState);
            }
        } else if (recordingRecord.hasAudioEnabled()) {
            if (!isAudioSupported()) {
                throw new AssertionError("The Recorder doesn't support recording with audio");
            }
            try {
                if (!this.mInProgressRecording.isPersistent() || this.mAudioEncoder == null) {
                    setupAudio(recordingRecord);
                }
                setAudioState(AudioState.ENABLED);
            } catch (AudioSourceAccessException | InvalidConfigException e) {
                Logger.e(TAG, "Unable to create audio resource with error: ", e);
                if (e instanceof InvalidConfigException) {
                    audioState = AudioState.ERROR_ENCODER;
                } else {
                    audioState = AudioState.ERROR_SOURCE;
                }
                setAudioState(audioState);
                this.mAudioErrorCause = e;
            }
        }
        updateEncoderCallbacks(recordingRecord, false);
        if (isAudioEnabled()) {
            this.mAudioSource.start(recordingRecord.isMuted());
            this.mAudioEncoder.start();
        }
        this.mVideoEncoder.start();
        RecordingRecord recordingRecord2 = this.mInProgressRecording;
        recordingRecord2.updateVideoRecordEvent(VideoRecordEvent.start(recordingRecord2.getOutputOptions(), getInProgressRecordingStats()));
    }

    private void updateEncoderCallbacks(final RecordingRecord recordingRecord, boolean z) {
        if (!this.mEncodingFutures.isEmpty()) {
            ListenableFuture listenableFutureAllAsList = Futures.allAsList(this.mEncodingFutures);
            if (!listenableFutureAllAsList.isDone()) {
                listenableFutureAllAsList.cancel(true);
            }
            this.mEncodingFutures.clear();
        }
        this.mEncodingFutures.add(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda2
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f$0.m1178lambda$updateEncoderCallbacks$12$androidxcameravideoRecorder(recordingRecord, completer);
            }
        }));
        if (isAudioEnabled() && !z) {
            this.mEncodingFutures.add(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda3
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return this.f$0.m1180lambda$updateEncoderCallbacks$14$androidxcameravideoRecorder(recordingRecord, completer);
                }
            }));
        }
        Futures.addCallback(Futures.allAsList(this.mEncodingFutures), new FutureCallback<List<Void>>() { // from class: androidx.camera.video.Recorder.6
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(List<Void> list) {
                Logger.d(Recorder.TAG, "Encodings end successfully.");
                Recorder recorder = Recorder.this;
                recorder.finalizeInProgressRecording(recorder.mRecordingStopError, Recorder.this.mRecordingStopErrorCause);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                Preconditions.checkState(Recorder.this.mInProgressRecording != null, "In-progress recording shouldn't be null");
                if (Recorder.this.mInProgressRecording.isPersistent()) {
                    return;
                }
                Logger.d(Recorder.TAG, "Encodings end with error: " + th);
                Recorder recorder = Recorder.this;
                recorder.finalizeInProgressRecording(recorder.mMuxer == null ? 8 : 6, th);
            }
        }, CameraXExecutors.directExecutor());
    }

    /* JADX INFO: renamed from: lambda$updateEncoderCallbacks$12$androidx-camera-video-Recorder, reason: not valid java name */
    /* synthetic */ Object m1178lambda$updateEncoderCallbacks$12$androidxcameravideoRecorder(final RecordingRecord recordingRecord, final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mVideoEncoder.setEncoderCallback(new EncoderCallback() { // from class: androidx.camera.video.Recorder.3
            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onEncodeStart() {
            }

            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onEncodeStop() {
                completer.set(null);
            }

            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onEncodeError(EncodeException encodeException) {
                completer.setException(encodeException);
            }

            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onEncodedData(EncodedData encodedData) {
                boolean z;
                Muxer muxer = Recorder.this.mMuxer;
                Recorder recorder = Recorder.this;
                if (muxer == null) {
                    if (!recorder.mInProgressRecordingStopping) {
                        if (Recorder.this.mPendingFirstVideoData != null) {
                            Recorder.this.mPendingFirstVideoData.close();
                            Recorder.this.mPendingFirstVideoData = null;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (encodedData.isKeyFrame()) {
                            Recorder.this.mPendingFirstVideoData = encodedData;
                            if (!Recorder.this.isAudioEnabled() || !Recorder.this.mPendingAudioRingBuffer.isEmpty()) {
                                Logger.d(Recorder.TAG, "Received video keyframe. Starting muxer...");
                                Recorder.this.setupAndStartMuxer(recordingRecord);
                                return;
                            } else if (z) {
                                Logger.d(Recorder.TAG, "Replaced cached video keyframe with newer keyframe.");
                                return;
                            } else {
                                Logger.d(Recorder.TAG, "Cached video keyframe while we wait for first audio sample before starting muxer.");
                                return;
                            }
                        }
                        if (z) {
                            Logger.d(Recorder.TAG, "Dropped cached keyframe since we have new video data and have not yet received audio data.");
                        }
                        Logger.d(Recorder.TAG, "Dropped video data since muxer has not yet started and data is not a keyframe.");
                        Recorder.this.mVideoEncoder.requestKeyFrame();
                        encodedData.close();
                        return;
                    }
                    Logger.d(Recorder.TAG, "Drop video data since recording is stopping.");
                    encodedData.close();
                    return;
                }
                try {
                    recorder.writeVideoData(encodedData, recordingRecord);
                    if (encodedData != null) {
                        encodedData.close();
                    }
                } catch (Throwable th) {
                    if (encodedData != null) {
                        try {
                            encodedData.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }

            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onOutputConfigUpdate(OutputConfig outputConfig) {
                Recorder.this.mVideoOutputConfig = outputConfig;
            }
        }, this.mSequentialExecutor);
        return "videoEncodingFuture";
    }

    /* JADX INFO: renamed from: lambda$updateEncoderCallbacks$14$androidx-camera-video-Recorder, reason: not valid java name */
    /* synthetic */ Object m1180lambda$updateEncoderCallbacks$14$androidxcameravideoRecorder(final RecordingRecord recordingRecord, final CallbackToFutureAdapter.Completer completer) throws Exception {
        final Consumer consumer = new Consumer() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda14
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                this.f$0.m1179lambda$updateEncoderCallbacks$13$androidxcameravideoRecorder(completer, (Throwable) obj);
            }
        };
        this.mAudioSource.setAudioSourceCallback(this.mSequentialExecutor, new AudioSource.AudioSourceCallback() { // from class: androidx.camera.video.Recorder.4
            @Override // androidx.camera.video.internal.audio.AudioSource.AudioSourceCallback
            public void onSilenceStateChanged(boolean z) {
                if (Recorder.this.mIsAudioSourceSilenced != z) {
                    Recorder.this.mIsAudioSourceSilenced = z;
                    Recorder.this.updateInProgressStatusEvent(true);
                } else {
                    Logger.w(Recorder.TAG, "Audio source silenced transitions to the same state " + z);
                }
            }

            @Override // androidx.camera.video.internal.audio.AudioSource.AudioSourceCallback
            public void onError(Throwable th) {
                Logger.e(Recorder.TAG, "Error occurred after audio source started.", th);
                if (th instanceof AudioSourceAccessException) {
                    consumer.accept(th);
                }
            }

            @Override // androidx.camera.video.internal.audio.AudioSource.AudioSourceCallback
            public void onAmplitudeValue(double d) {
                Recorder.this.mAudioAmplitude = d;
            }
        });
        this.mAudioEncoder.setEncoderCallback(new EncoderCallback() { // from class: androidx.camera.video.Recorder.5
            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onEncodeStart() {
            }

            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onEncodeStop() {
                completer.set(null);
            }

            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onEncodeError(EncodeException encodeException) {
                if (Recorder.this.mAudioErrorCause == null) {
                    consumer.accept(encodeException);
                }
            }

            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onEncodedData(EncodedData encodedData) {
                if (Recorder.this.mAudioState == AudioState.DISABLED) {
                    encodedData.close();
                    throw new AssertionError("Audio is not enabled but audio encoded data is being produced.");
                }
                Muxer muxer = Recorder.this.mMuxer;
                Recorder recorder = Recorder.this;
                if (muxer == null) {
                    if (!recorder.mInProgressRecordingStopping) {
                        Recorder.this.mPendingAudioRingBuffer.enqueue(new BufferCopiedEncodedData(encodedData));
                        if (Recorder.this.mPendingFirstVideoData != null) {
                            Logger.d(Recorder.TAG, "Received audio data. Starting muxer...");
                            Recorder.this.setupAndStartMuxer(recordingRecord);
                        } else {
                            Logger.d(Recorder.TAG, "Cached audio data while we wait for video keyframe before starting muxer.");
                        }
                    } else {
                        Logger.d(Recorder.TAG, "Drop audio data since recording is stopping.");
                    }
                    encodedData.close();
                    return;
                }
                try {
                    recorder.writeAudioData(encodedData, recordingRecord);
                    if (encodedData != null) {
                        encodedData.close();
                    }
                } catch (Throwable th) {
                    if (encodedData != null) {
                        try {
                            encodedData.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }

            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onOutputConfigUpdate(OutputConfig outputConfig) {
                Recorder.this.mAudioOutputConfig = outputConfig;
            }
        }, this.mSequentialExecutor);
        return "audioEncodingFuture";
    }

    /* JADX INFO: renamed from: lambda$updateEncoderCallbacks$13$androidx-camera-video-Recorder, reason: not valid java name */
    /* synthetic */ void m1179lambda$updateEncoderCallbacks$13$androidxcameravideoRecorder(CallbackToFutureAdapter.Completer completer, Throwable th) {
        if (this.mAudioErrorCause == null) {
            if (th instanceof EncodeException) {
                setAudioState(AudioState.ERROR_ENCODER);
            } else {
                setAudioState(AudioState.ERROR_SOURCE);
            }
            this.mAudioErrorCause = th;
            updateInProgressStatusEvent(true);
            completer.set(null);
        }
    }

    void writeVideoData(EncodedData encodedData, RecordingRecord recordingRecord) {
        if (this.mVideoEncoder == null) {
            Logger.d(TAG, "Ignore the video data since the video encoder has been released.");
            return;
        }
        if (this.mVideoTrackIndex == null) {
            throw new AssertionError("Video data comes before the track is added to Muxer.");
        }
        long size = this.mRecordingBytes + encodedData.size();
        long j = this.mFileSizeLimitInBytes;
        long j2 = 0;
        if (j != 0 && size > j) {
            Logger.d(TAG, String.format("Reach file size limit %d > %d", Long.valueOf(size), Long.valueOf(this.mFileSizeLimitInBytes)));
            onInProgressRecordingInternalError(recordingRecord, 2, null);
            return;
        }
        long presentationTimeUs = encodedData.getPresentationTimeUs();
        long j3 = this.mFirstRecordingVideoDataTimeUs;
        if (j3 == Long.MAX_VALUE) {
            this.mFirstRecordingVideoDataTimeUs = presentationTimeUs;
            Logger.d(TAG, String.format("First video time: %d (%s)", Long.valueOf(presentationTimeUs), DebugUtils.readableUs(this.mFirstRecordingVideoDataTimeUs)));
        } else {
            long j4 = presentationTimeUs - j3;
            if (this.mDurationLimitUs != 0) {
                Preconditions.checkState(this.mPreviousRecordingVideoDataTimeUs != Long.MAX_VALUE, "There should be a previous data for adjusting the duration.");
                long j5 = (presentationTimeUs - this.mPreviousRecordingVideoDataTimeUs) + j4;
                if (j5 > this.mDurationLimitUs) {
                    Logger.d(TAG, String.format("Video data reaches duration limit %d > %d", Long.valueOf(j5), Long.valueOf(this.mDurationLimitUs)));
                    onInProgressRecordingInternalError(recordingRecord, 9, null);
                    return;
                }
            }
            j2 = j4;
        }
        encodedData.getBufferInfo().presentationTimeUs = j2;
        try {
            this.mMuxer.writeSampleData(this.mVideoTrackIndex.intValue(), encodedData.getByteBuffer(), encodedData.getBufferInfo());
            this.mRecordingBytes = size;
            this.mRecordingDurationUs = j2;
            this.mPreviousRecordingVideoDataTimeUs = presentationTimeUs;
            updateInProgressStatusEvent(encodedData.isKeyFrame());
            if (size > this.mAvailableBytesAboveRequired) {
                long availableBytes = ((OutputStorage) Preconditions.checkNotNull(this.mOutputStorage)).getAvailableBytes();
                Logger.d(TAG, "availableBytes = " + StorageUtil.formatSize(availableBytes));
                if (hasInsufficientStorage(availableBytes)) {
                    onInProgressRecordingInternalError(recordingRecord, 3, new IOException(String.format(INSUFFICIENT_STORAGE_ERROR_MSG, Long.valueOf(availableBytes), Long.valueOf(this.mRequiredFreeStorageBytes))));
                } else {
                    this.mAvailableBytesAboveRequired = availableBytes - this.mRequiredFreeStorageBytes;
                }
            }
        } catch (MuxerException e) {
            Logger.w(TAG, "writeVideoData failed", e);
            onInProgressRecordingInternalError(recordingRecord, hasInsufficientStorageOrException(e) ? 3 : 1, e);
        }
    }

    void writeAudioData(EncodedData encodedData, RecordingRecord recordingRecord) {
        if (this.mAudioEncoder == null) {
            Logger.d(TAG, "Ignore the audio data since the audio encoder has been released.");
            return;
        }
        if (encodedData.getPresentationTimeUs() < this.mFirstRecordingVideoDataTimeUs) {
            Logger.d(TAG, "Skipping audio data: timestamp precedes first video frame.");
            return;
        }
        long size = this.mRecordingBytes + encodedData.size();
        long j = this.mFileSizeLimitInBytes;
        if (j != 0 && size > j) {
            Logger.d(TAG, String.format("Reach file size limit %d > %d", Long.valueOf(size), Long.valueOf(this.mFileSizeLimitInBytes)));
            onInProgressRecordingInternalError(recordingRecord, 2, null);
            return;
        }
        long presentationTimeUs = encodedData.getPresentationTimeUs();
        long j2 = presentationTimeUs - this.mFirstRecordingVideoDataTimeUs;
        if (this.mFirstRecordingAudioDataTimeUs == Long.MAX_VALUE) {
            this.mFirstRecordingAudioDataTimeUs = presentationTimeUs;
            Logger.d(TAG, String.format("First audio time: %d (%s)", Long.valueOf(presentationTimeUs), DebugUtils.readableUs(this.mFirstRecordingAudioDataTimeUs)));
        } else if (this.mDurationLimitUs != 0) {
            Preconditions.checkState(this.mPreviousRecordingAudioDataTimeUs != Long.MAX_VALUE, "There should be a previous data for adjusting the duration.");
            long j3 = (presentationTimeUs - this.mPreviousRecordingAudioDataTimeUs) + j2;
            if (j3 > this.mDurationLimitUs) {
                Logger.d(TAG, String.format("Audio data reaches duration limit %d > %d", Long.valueOf(j3), Long.valueOf(this.mDurationLimitUs)));
                onInProgressRecordingInternalError(recordingRecord, 9, null);
                return;
            }
        }
        encodedData.getBufferInfo().presentationTimeUs = j2;
        try {
            this.mMuxer.writeSampleData(this.mAudioTrackIndex.intValue(), encodedData.getByteBuffer(), encodedData.getBufferInfo());
            this.mRecordingBytes = size;
            this.mRecordingAudioBytes += encodedData.size();
            this.mPreviousRecordingAudioDataTimeUs = presentationTimeUs;
        } catch (MuxerException e) {
            Logger.w(TAG, "writeAudioData failed", e);
            onInProgressRecordingInternalError(recordingRecord, hasInsufficientStorageOrException(e) ? 3 : 1, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: pauseInternal, reason: merged with bridge method [inline-methods] */
    public void m1173lambda$pause$5$androidxcameravideoRecorder(RecordingRecord recordingRecord) {
        if (this.mInProgressRecording != recordingRecord || this.mInProgressRecordingStopping) {
            return;
        }
        if (isAudioEnabled()) {
            this.mAudioEncoder.pause();
        }
        this.mVideoEncoder.pause();
        RecordingRecord recordingRecord2 = this.mInProgressRecording;
        recordingRecord2.updateVideoRecordEvent(VideoRecordEvent.pause(recordingRecord2.getOutputOptions(), getInProgressRecordingStats()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: resumeInternal, reason: merged with bridge method [inline-methods] */
    public void m1174lambda$resume$6$androidxcameravideoRecorder(RecordingRecord recordingRecord) {
        if (this.mInProgressRecording != recordingRecord || this.mInProgressRecordingStopping) {
            return;
        }
        if (isAudioEnabled()) {
            this.mAudioEncoder.start();
        }
        Encoder encoder = this.mVideoEncoder;
        if (encoder != null) {
            encoder.start();
            RecordingRecord recordingRecord2 = this.mInProgressRecording;
            recordingRecord2.updateVideoRecordEvent(VideoRecordEvent.resume(recordingRecord2.getOutputOptions(), getInProgressRecordingStats()));
            return;
        }
        this.mShouldSendResumeEvent = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: stopInternal, reason: merged with bridge method [inline-methods] */
    public void m1177lambda$stop$7$androidxcameravideoRecorder(RecordingRecord recordingRecord, long j, int i, Throwable th) {
        if (this.mInProgressRecording != recordingRecord || this.mInProgressRecordingStopping) {
            return;
        }
        this.mInProgressRecordingStopping = true;
        this.mRecordingStopError = i;
        this.mRecordingStopErrorCause = th;
        if (isAudioEnabled()) {
            clearPendingAudioRingBuffer();
            this.mAudioEncoder.stop(j);
        }
        EncodedData encodedData = this.mPendingFirstVideoData;
        if (encodedData != null) {
            encodedData.close();
            this.mPendingFirstVideoData = null;
        }
        if (this.mSourceState != VideoOutput.SourceState.ACTIVE_NON_STREAMING) {
            this.mSourceNonStreamingTimeout = scheduleTask(new Runnable() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    Logger.d(Recorder.TAG, "The source didn't become non-streaming before timeout. Waited 1000ms");
                }
            }, this.mSequentialExecutor, 1000L, TimeUnit.MILLISECONDS);
        } else {
            notifyEncoderSourceStopped(this.mVideoEncoder);
        }
        this.mVideoEncoder.stop(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: muteInternal, reason: merged with bridge method [inline-methods] */
    public void m1170lambda$mute$8$androidxcameravideoRecorder(RecordingRecord recordingRecord, boolean z) {
        AudioSource audioSource;
        if (recordingRecord.isMuted() == z) {
            return;
        }
        recordingRecord.mute(z);
        if (this.mInProgressRecording != recordingRecord || this.mInProgressRecordingStopping || (audioSource = this.mAudioSource) == null) {
            return;
        }
        audioSource.mute(z);
    }

    static void notifyEncoderSourceStopped(Encoder encoder) {
        if (encoder instanceof EncoderImpl) {
            ((EncoderImpl) encoder).signalSourceStopped();
        }
    }

    private void clearPendingAudioRingBuffer() {
        while (!this.mPendingAudioRingBuffer.isEmpty()) {
            this.mPendingAudioRingBuffer.dequeue().close();
        }
    }

    private void reset() {
        if (this.mAudioEncoder != null) {
            Logger.d(TAG, "Releasing audio encoder.");
            this.mAudioEncoder.release();
            this.mAudioEncoder = null;
            this.mAudioOutputConfig = null;
        }
        if (this.mAudioSource != null) {
            releaseCurrentAudioSource();
        }
        setAudioState(AudioState.INITIALIZING);
        resetVideo();
    }

    private void tryReleaseVideoEncoder() {
        VideoEncoderSession videoEncoderSession = this.mVideoEncoderSessionToRelease;
        if (videoEncoderSession != null) {
            Preconditions.checkState(videoEncoderSession.getVideoEncoder() == this.mVideoEncoder);
            Logger.d(TAG, "Releasing video encoder: " + this.mVideoEncoder);
            this.mVideoEncoderSessionToRelease.terminateNow();
            this.mVideoEncoderSessionToRelease = null;
            this.mVideoEncoder = null;
            this.mVideoOutputConfig = null;
            setLatestSurface(null);
            return;
        }
        safeToCloseVideoEncoder();
    }

    private void onResetVideo() {
        boolean z;
        SurfaceRequest surfaceRequest;
        synchronized (this.mLock) {
            switch (this.mState.ordinal()) {
                case 1:
                case 2:
                    updateNonPendingState(State.CONFIGURING);
                    z = true;
                    break;
                case 4:
                case 5:
                case 8:
                    if (isPersistentRecordingInProgress()) {
                        z = false;
                        break;
                    }
                case 3:
                case 6:
                case 7:
                    setState(State.CONFIGURING);
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
        }
        this.mNeedsResetBeforeNextStart = false;
        if (!z || (surfaceRequest = this.mLatestSurfaceRequest) == null || surfaceRequest.isServiced()) {
            return;
        }
        configureInternal(this.mLatestSurfaceRequest, this.mVideoSourceTimebase, false);
    }

    private void resetVideo() {
        if (this.mVideoEncoder != null) {
            Logger.d(TAG, "Releasing video encoder.");
            tryReleaseVideoEncoder();
        }
        onResetVideo();
    }

    private int internalAudioStateToAudioStatsState(AudioState audioState) {
        int iOrdinal = audioState.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            return 1;
        }
        if (iOrdinal == 3) {
            RecordingRecord recordingRecord = this.mInProgressRecording;
            if (recordingRecord == null || !recordingRecord.isMuted()) {
                return this.mIsAudioSourceSilenced ? 2 : 0;
            }
            return 5;
        }
        if (iOrdinal == 4) {
            return 3;
        }
        if (iOrdinal == 5) {
            return 4;
        }
        throw new AssertionError("Invalid internal audio state: " + audioState);
    }

    private StreamInfo.StreamState internalStateToStreamState(State state) {
        return (state == State.RECORDING || state == State.STOPPING) ? StreamInfo.StreamState.ACTIVE : StreamInfo.StreamState.INACTIVE;
    }

    boolean isAudioEnabled() {
        return this.mAudioState == AudioState.ENABLED;
    }

    private boolean hasInsufficientStorage(long j) {
        return j < this.mRequiredFreeStorageBytes;
    }

    private boolean hasInsufficientStorageOrException(Throwable th) {
        if (StorageUtil.isStorageFullException(th)) {
            return true;
        }
        return hasInsufficientStorage(((OutputStorage) Preconditions.checkNotNull(this.mOutputStorage)).getAvailableBytes());
    }

    private boolean hasInvalidRecordData() {
        if (this.mRecordingBytes > 0) {
            return isAudioEnabled() && this.mRecordingAudioBytes <= 0;
        }
        return true;
    }

    void finalizeInProgressRecording(int i, Throwable th) {
        if (this.mInProgressRecording == null) {
            throw new AssertionError("Attempted to finalize in-progress recording, but no recording is in progress.");
        }
        if (this.mMuxer != null) {
            try {
                try {
                    Logger.d(TAG, "Muxer.stop()");
                    this.mMuxer.stop();
                } catch (MuxerException e) {
                    Logger.w(TAG, "Muxer failed to stop with error: " + e, e);
                    if (i == 0) {
                        if (hasInsufficientStorageOrException(e)) {
                            i = 3;
                        } else {
                            i = hasInvalidRecordData() ? 8 : 1;
                        }
                        th = e;
                    }
                }
                Logger.d(TAG, "Muxer.release()");
                this.mMuxer.release();
                this.mMuxer = null;
            } catch (Throwable th2) {
                Logger.d(TAG, "Muxer.release()");
                this.mMuxer.release();
                this.mMuxer = null;
                throw th2;
            }
        } else if (i == 0) {
            i = 8;
        }
        this.mInProgressRecording.finalizeRecording(this.mOutputUri);
        OutputOptions outputOptions = this.mInProgressRecording.getOutputOptions();
        RecordingStats inProgressRecordingStats = getInProgressRecordingStats();
        OutputResults outputResultsOf = OutputResults.of(this.mOutputUri);
        this.mInProgressRecording.updateVideoRecordEvent(i == 0 ? VideoRecordEvent.finalize(outputOptions, inProgressRecordingStats, outputResultsOf) : VideoRecordEvent.finalizeWithError(outputOptions, inProgressRecordingStats, outputResultsOf, i, th));
        RecordingRecord recordingRecord = this.mInProgressRecording;
        this.mInProgressRecording = null;
        this.mInProgressRecordingStopping = false;
        this.mAudioTrackIndex = null;
        this.mVideoTrackIndex = null;
        this.mEncodingFutures.clear();
        this.mOutputUri = Uri.EMPTY;
        this.mRecordingBytes = 0L;
        this.mRecordingAudioBytes = 0L;
        this.mRecordingDurationUs = 0L;
        this.mFirstRecordingVideoDataTimeUs = Long.MAX_VALUE;
        this.mFirstRecordingAudioDataTimeUs = Long.MAX_VALUE;
        this.mPreviousRecordingVideoDataTimeUs = Long.MAX_VALUE;
        this.mPreviousRecordingAudioDataTimeUs = Long.MAX_VALUE;
        this.mRecordingStopError = 1;
        this.mRecordingStopErrorCause = null;
        this.mAudioErrorCause = null;
        this.mAudioAmplitude = 0.0d;
        this.mOutputStorage = null;
        this.mAvailableBytesAboveRequired = Long.MAX_VALUE;
        clearPendingAudioRingBuffer();
        setInProgressTransformationInfo(null);
        int iOrdinal = this.mAudioState.ordinal();
        if (iOrdinal == 2 || iOrdinal == 3) {
            setAudioState(AudioState.IDLING);
            this.mAudioSource.stop();
        } else if (iOrdinal == 4 || iOrdinal == 5) {
            setAudioState(AudioState.INITIALIZING);
        }
        onRecordingFinalized(recordingRecord);
    }

    private void onRecordingFinalized(RecordingRecord recordingRecord) {
        RecordingRecord recordingRecordMakePendingRecordingActiveLocked;
        boolean z;
        boolean z2;
        RecordingRecord recordingRecord2;
        Exception exc;
        int i;
        synchronized (this.mLock) {
            RecordingRecord recordingRecord3 = this.mActiveRecordingRecord;
            if (recordingRecord3 != recordingRecord) {
                throw new AssertionError("Active recording did not match finalized recording on finalize.");
            }
            recordingRecord3.getRecordingState().removeObservers();
            recordingRecordMakePendingRecordingActiveLocked = null;
            this.mActiveRecordingRecord = null;
            z = true;
            z2 = false;
            switch (this.mState.ordinal()) {
                case 1:
                    z = false;
                case 2:
                    if (this.mSourceState == VideoOutput.SourceState.INACTIVE) {
                        recordingRecord2 = this.mPendingRecordingRecord;
                        this.mPendingRecordingRecord = null;
                        setState(State.CONFIGURING);
                        exc = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE;
                        i = 4;
                        z2 = z;
                        z = false;
                    } else if (this.mVideoEncoder != null) {
                        exc = null;
                        i = 0;
                        recordingRecordMakePendingRecordingActiveLocked = makePendingRecordingActiveLocked(this.mState);
                        z2 = z;
                        z = false;
                        recordingRecord2 = null;
                    } else {
                        recordingRecord2 = null;
                        exc = null;
                        i = 0;
                        z2 = z;
                        z = false;
                    }
                    break;
                case 3:
                    throw new AssertionError("Unexpected state on finalize of recording: " + this.mState);
                case 4:
                case 5:
                case 6:
                    setState(State.IDLING);
                    recordingRecord2 = null;
                    exc = null;
                    z = false;
                    i = 0;
                    break;
                case 7:
                    recordingRecord2 = null;
                    exc = null;
                    i = 0;
                    break;
                default:
                    recordingRecord2 = null;
                    exc = null;
                    z = false;
                    i = 0;
                    break;
            }
        }
        if (z) {
            reset();
        } else if (recordingRecordMakePendingRecordingActiveLocked != null) {
            startRecording(recordingRecordMakePendingRecordingActiveLocked, z2);
        } else if (recordingRecord2 != null) {
            finalizePendingRecording(recordingRecord2, i, exc);
        }
    }

    void onInProgressRecordingInternalError(RecordingRecord recordingRecord, int i, Throwable th) {
        boolean z;
        if (recordingRecord != this.mInProgressRecording) {
            throw new AssertionError("Internal error occurred on recording that is not the current in-progress recording.");
        }
        synchronized (this.mLock) {
            z = false;
            switch (this.mState) {
                case CONFIGURING:
                case IDLING:
                case ERROR:
                    throw new AssertionError("In-progress recording error occurred while in unexpected state: " + this.mState);
                case RECORDING:
                case PAUSED:
                    setState(State.STOPPING);
                    z = true;
                case PENDING_RECORDING:
                case PENDING_PAUSED:
                case STOPPING:
                case RESETTING:
                    if (recordingRecord != this.mActiveRecordingRecord) {
                        throw new AssertionError("Internal error occurred for recording but it is not the active recording.");
                    }
                    break;
                    break;
                default:
                    break;
            }
        }
        if (z) {
            m1177lambda$stop$7$androidxcameravideoRecorder(recordingRecord, -1L, i, th);
        }
    }

    void tryServicePendingRecording() {
        boolean z;
        RecordingRecord recordingRecordMakePendingRecordingActiveLocked;
        int i;
        Throwable th;
        synchronized (this.mLock) {
            Logger.d(TAG, "tryServicePendingRecording on state: " + this.mState);
            int iOrdinal = this.mState.ordinal();
            boolean z2 = true;
            z = false;
            i = 0;
            recordingRecordMakePendingRecordingActiveLocked = null;
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    i = 0;
                    recordingRecordMakePendingRecordingActiveLocked = null;
                }
                th = recordingRecordMakePendingRecordingActiveLocked;
            } else {
                z2 = false;
            }
            if (this.mSourceState == VideoOutput.SourceState.INACTIVE) {
                RecordingRecord recordingRecord = this.mPendingRecordingRecord;
                this.mPendingRecordingRecord = null;
                restoreNonPendingState();
                recordingRecordMakePendingRecordingActiveLocked = recordingRecord;
                i = 4;
                z = z2;
                th = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE;
            } else {
                if (this.mActiveRecordingRecord != null || this.mNeedsResetBeforeNextStart) {
                    Logger.w(TAG, "PendingRecording is not handled, active recording = " + this.mActiveRecordingRecord + ", need reset flag = " + this.mNeedsResetBeforeNextStart);
                } else {
                    recordingRecordMakePendingRecordingActiveLocked = this.mVideoEncoder != null ? makePendingRecordingActiveLocked(this.mState) : null;
                    z = z2;
                    th = recordingRecordMakePendingRecordingActiveLocked;
                }
                z = z2;
                th = recordingRecordMakePendingRecordingActiveLocked;
            }
        }
        if (recordingRecordMakePendingRecordingActiveLocked != null) {
            startRecording(recordingRecordMakePendingRecordingActiveLocked, z);
        } else if (recordingRecordMakePendingRecordingActiveLocked != null) {
            finalizePendingRecording(recordingRecordMakePendingRecordingActiveLocked, i, th);
        }
    }

    private RecordingRecord makePendingRecordingActiveLocked(State state) {
        boolean z;
        if (state == State.PENDING_PAUSED) {
            z = true;
        } else {
            if (state != State.PENDING_RECORDING) {
                throw new AssertionError("makePendingRecordingActiveLocked() can only be called from a pending state.");
            }
            z = false;
        }
        if (this.mActiveRecordingRecord != null) {
            throw new AssertionError("Cannot make pending recording active because another recording is already active.");
        }
        RecordingRecord recordingRecord = this.mPendingRecordingRecord;
        if (recordingRecord == null) {
            throw new AssertionError("Pending recording should exist when in a PENDING state.");
        }
        this.mActiveRecordingRecord = recordingRecord;
        recordingRecord.getRecordingState().addObserver(CameraXExecutors.directExecutor(), new Observable.Observer<Boolean>() { // from class: androidx.camera.video.Recorder.7
            @Override // androidx.camera.core.impl.Observable.Observer
            public void onNewData(Boolean bool) {
                Recorder.this.mIsRecording.setState(bool);
            }

            @Override // androidx.camera.core.impl.Observable.Observer
            public void onError(Throwable th) {
                Recorder.this.mIsRecording.setError(th);
            }
        });
        this.mPendingRecordingRecord = null;
        if (z) {
            setState(State.PAUSED);
            return recordingRecord;
        }
        setState(State.RECORDING);
        return recordingRecord;
    }

    private void startRecording(RecordingRecord recordingRecord, boolean z) {
        startInternal(recordingRecord);
        if (z) {
            m1173lambda$pause$5$androidxcameravideoRecorder(recordingRecord);
        }
    }

    void updateInProgressStatusEvent(boolean z) {
        RecordingRecord recordingRecord = this.mInProgressRecording;
        if (recordingRecord != null) {
            recordingRecord.updateVideoRecordEvent(VideoRecordEvent.status(recordingRecord.getOutputOptions(), getInProgressRecordingStats()), z);
        }
    }

    RecordingStats getInProgressRecordingStats() {
        return RecordingStats.of(TimeUnit.MICROSECONDS.toNanos(this.mRecordingDurationUs), this.mRecordingBytes, AudioStats.of(internalAudioStateToAudioStatsState(this.mAudioState), this.mAudioErrorCause, this.mAudioAmplitude, this.mRecordingAudioBytes));
    }

    <T> T getObservableData(StateObservable<T> stateObservable) {
        try {
            return stateObservable.fetchData().get();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException(e);
        }
    }

    boolean isAudioSupported() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getAudioSpec().getChannelCount() != 0;
    }

    void setState(State state) {
        if (this.mState == state) {
            throw new AssertionError("Attempted to transition to state " + state + ", but Recorder is already in state " + state);
        }
        Logger.d(TAG, "Transitioning Recorder internal state: " + this.mState + " --> " + state);
        Set<State> set = PENDING_STATES;
        StreamInfo.StreamState streamStateInternalStateToStreamState = null;
        if (set.contains(state)) {
            if (!set.contains(this.mState)) {
                boolean zContains = VALID_NON_PENDING_STATES_WHILE_PENDING.contains(this.mState);
                State state2 = this.mState;
                if (!zContains) {
                    throw new AssertionError("Invalid state transition. Should not be transitioning to a PENDING state from state " + state2);
                }
                this.mNonPendingState = state2;
                streamStateInternalStateToStreamState = internalStateToStreamState(state2);
            }
        } else if (this.mNonPendingState != null) {
            this.mNonPendingState = null;
        }
        this.mState = state;
        if (streamStateInternalStateToStreamState == null) {
            streamStateInternalStateToStreamState = internalStateToStreamState(state);
        }
        this.mStreamInfo.setState(StreamInfo.of(this.mStreamId, streamStateInternalStateToStreamState, this.mInProgressTransformationInfo));
    }

    void setLatestSurface(Surface surface) {
        int iHashCode;
        if (this.mLatestSurface == surface) {
            return;
        }
        this.mLatestSurface = surface;
        synchronized (this.mLock) {
            if (surface != null) {
                try {
                    iHashCode = surface.hashCode();
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                iHashCode = 0;
            }
            setStreamId(iHashCode);
        }
    }

    private void setStreamId(int i) {
        if (this.mStreamId == i) {
            return;
        }
        Logger.d(TAG, "Transitioning streamId: " + this.mStreamId + " --> " + i);
        this.mStreamId = i;
        this.mStreamInfo.setState(StreamInfo.of(i, internalStateToStreamState(this.mState), this.mInProgressTransformationInfo));
    }

    void setInProgressTransformationInfo(SurfaceRequest.TransformationInfo transformationInfo) {
        Logger.d(TAG, "Update stream transformation info: " + transformationInfo);
        this.mInProgressTransformationInfo = transformationInfo;
        synchronized (this.mLock) {
            this.mStreamInfo.setState(StreamInfo.of(this.mStreamId, internalStateToStreamState(this.mState), transformationInfo));
        }
    }

    private void updateNonPendingState(State state) {
        if (!PENDING_STATES.contains(this.mState)) {
            throw new AssertionError("Can only updated non-pending state from a pending state, but state is " + this.mState);
        }
        if (!VALID_NON_PENDING_STATES_WHILE_PENDING.contains(state)) {
            throw new AssertionError("Invalid state transition. State is not a valid non-pending state while in a pending state: " + state);
        }
        if (this.mNonPendingState != state) {
            this.mNonPendingState = state;
            this.mStreamInfo.setState(StreamInfo.of(this.mStreamId, internalStateToStreamState(state), this.mInProgressTransformationInfo));
        }
    }

    private void restoreNonPendingState() {
        if (!PENDING_STATES.contains(this.mState)) {
            throw new AssertionError("Cannot restore non-pending state when in state " + this.mState);
        }
        setState(this.mNonPendingState);
    }

    void setAudioState(AudioState audioState) {
        Logger.d(TAG, "Transitioning audio state: " + this.mAudioState + " --> " + audioState);
        this.mAudioState = audioState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ScheduledFuture<?> scheduleTask(final Runnable runnable, final Executor executor, long j, TimeUnit timeUnit) {
        return CameraXExecutors.mainThreadExecutor().schedule(new Runnable() { // from class: androidx.camera.video.Recorder$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                executor.execute(runnable);
            }
        }, j, timeUnit);
    }

    private static int supportedMuxerFormatOrDefaultFrom(VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, int i) {
        if (videoValidatedEncoderProfilesProxy != null) {
            int recommendedFileFormat = videoValidatedEncoderProfilesProxy.getRecommendedFileFormat();
            if (recommendedFileFormat == 1) {
                return 2;
            }
            if (recommendedFileFormat == 2) {
                return 0;
            }
            if (recommendedFileFormat == 9) {
                return 1;
            }
        }
        return i;
    }

    public static VideoCapabilities getVideoCapabilities(CameraInfo cameraInfo) {
        return getVideoCapabilitiesInternal(1, cameraInfo, 0, VideoSpec.MIME_TYPE_UNSPECIFIED);
    }

    public static VideoCapabilities getVideoCapabilities(CameraInfo cameraInfo, String str) {
        return getVideoCapabilitiesInternal(1, cameraInfo, 0, str);
    }

    public static VideoCapabilities getVideoCapabilities(CameraInfo cameraInfo, int i) {
        return getVideoCapabilitiesInternal(1, cameraInfo, i, VideoSpec.MIME_TYPE_UNSPECIFIED);
    }

    public static VideoCapabilities getHighSpeedVideoCapabilities(CameraInfo cameraInfo) {
        return getHighSpeedVideoCapabilities(cameraInfo, 0);
    }

    public static VideoCapabilities getHighSpeedVideoCapabilities(CameraInfo cameraInfo, int i) {
        VideoCapabilities videoCapabilitiesInternal = getVideoCapabilitiesInternal(2, cameraInfo, i, VideoSpec.MIME_TYPE_UNSPECIFIED);
        if (videoCapabilitiesInternal.getSupportedDynamicRanges().isEmpty()) {
            return null;
        }
        return videoCapabilitiesInternal;
    }

    private static VideoCapabilities getVideoCapabilitiesInternal(int i, CameraInfo cameraInfo, int i2, String str) {
        CameraInfoInternal cameraInfoInternal = (CameraInfoInternal) cameraInfo;
        if (VideoSpec.MIME_TYPE_UNSPECIFIED.equals(str)) {
            return new RecorderVideoCapabilities(getEncoderProfilesResolverInternal(i, cameraInfo, i2), cameraInfoInternal);
        }
        return new MimeMatchedVideoCapabilities(str, cameraInfoInternal, DEFAULT_VIDEO_ENCODER_INFO_FINDER);
    }

    @Override // androidx.camera.video.VideoOutput
    public EncoderProfilesResolver getEncoderProfilesResolver(CameraInfo cameraInfo, int i) {
        return getEncoderProfilesResolverInternal(i == 1 ? 2 : 1, cameraInfo, this.mVideoCapabilitiesSource);
    }

    private static EncoderProfilesResolver getEncoderProfilesResolverInternal(int i, CameraInfo cameraInfo, int i2) {
        return EncoderProfilesResolverFactory.getResolver(cameraInfo, i, i2, DEFAULT_VIDEO_ENCODER_INFO_FINDER);
    }

    static abstract class RecordingRecord implements AutoCloseable {
        private final CloseGuardHelper mCloseGuard = CloseGuardHelper.create();
        private final AtomicBoolean mInitialized = new AtomicBoolean(false);
        private final AtomicReference<MuxerSupplier> mMuxerSupplier = new AtomicReference<>(null);
        private final AtomicReference<AudioSourceSupplier> mAudioSourceSupplier = new AtomicReference<>(null);
        private final AtomicReference<Consumer<Uri>> mRecordingFinalizer = new AtomicReference<>(new Consumer() { // from class: androidx.camera.video.Recorder$RecordingRecord$$ExternalSyntheticLambda2
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Recorder.RecordingRecord.lambda$new$0((Uri) obj);
            }
        });
        private final AtomicBoolean mMuted = new AtomicBoolean(false);
        private final MutableStateObservable<Boolean> mRecordingState = MutableStateObservable.withInitialState(false);

        private interface AudioSourceSupplier {
            AudioSource get(AudioSettings audioSettings, Executor executor) throws AudioSourceAccessException;
        }

        /* JADX INFO: Access modifiers changed from: private */
        interface MuxerSupplier {
            Muxer get(int i, Consumer<Uri> consumer) throws IOException;
        }

        static /* synthetic */ void lambda$new$0(Uri uri) {
        }

        abstract Executor getCallbackExecutor();

        abstract Consumer<VideoRecordEvent> getEventListener();

        abstract OutputOptions getOutputOptions();

        abstract long getRecordingId();

        abstract boolean hasAudioEnabled();

        abstract boolean isPersistent();

        RecordingRecord() {
        }

        static RecordingRecord from(PendingRecording pendingRecording, long j) {
            AutoValue_Recorder_RecordingRecord autoValue_Recorder_RecordingRecord = new AutoValue_Recorder_RecordingRecord(pendingRecording.getOutputOptions(), pendingRecording.getListenerExecutor(), pendingRecording.getEventListener(), pendingRecording.getIsAudioEnabled(), pendingRecording.getIsPersistent(), j);
            autoValue_Recorder_RecordingRecord.mute(pendingRecording.getIsAudioInitialMuted());
            return autoValue_Recorder_RecordingRecord;
        }

        void initializeRecording(final Context context, final MuxerFactory muxerFactory) throws IOException {
            if (this.mInitialized.getAndSet(true)) {
                throw new AssertionError("Recording " + this + " has already been initialized");
            }
            final OutputOptions outputOptions = getOutputOptions();
            Consumer<Uri> consumer = null;
            final ParcelFileDescriptor parcelFileDescriptorDup = outputOptions instanceof FileDescriptorOutputOptions ? ((FileDescriptorOutputOptions) outputOptions).getParcelFileDescriptor().dup() : null;
            this.mCloseGuard.open("finalizeRecording");
            this.mMuxerSupplier.set(new MuxerSupplier() { // from class: androidx.camera.video.Recorder$RecordingRecord$$ExternalSyntheticLambda3
                @Override // androidx.camera.video.Recorder.RecordingRecord.MuxerSupplier
                public final Muxer get(int i, Consumer consumer2) {
                    return this.f$0.m1181xeed2925(muxerFactory, outputOptions, parcelFileDescriptorDup, i, consumer2);
                }
            });
            if (hasAudioEnabled()) {
                this.mAudioSourceSupplier.set(getAudioSourceSupplier(context));
            }
            if (outputOptions instanceof MediaStoreOutputOptions) {
                final MediaStoreOutputOptions mediaStoreOutputOptions = (MediaStoreOutputOptions) outputOptions;
                if (Build.VERSION.SDK_INT >= 29) {
                    consumer = new Consumer() { // from class: androidx.camera.video.Recorder$RecordingRecord$$ExternalSyntheticLambda4
                        @Override // androidx.core.util.Consumer
                        public final void accept(Object obj) {
                            Recorder.RecordingRecord.lambda$initializeRecording$2(mediaStoreOutputOptions, (Uri) obj);
                        }
                    };
                } else {
                    consumer = new Consumer() { // from class: androidx.camera.video.Recorder$RecordingRecord$$ExternalSyntheticLambda5
                        @Override // androidx.core.util.Consumer
                        public final void accept(Object obj) throws Throwable {
                            Recorder.RecordingRecord.lambda$initializeRecording$4(mediaStoreOutputOptions, context, (Uri) obj);
                        }
                    };
                }
            }
            if (consumer != null) {
                this.mRecordingFinalizer.set(consumer);
            }
        }

        /* JADX INFO: renamed from: lambda$initializeRecording$1$androidx-camera-video-Recorder$RecordingRecord, reason: not valid java name */
        /* synthetic */ Muxer m1181xeed2925(MuxerFactory muxerFactory, OutputOptions outputOptions, ParcelFileDescriptor parcelFileDescriptor, int i, Consumer consumer) throws Throwable {
            Muxer muxerCreate = muxerFactory.create(i);
            Uri uriInsert = Uri.EMPTY;
            if (outputOptions instanceof FileOutputOptions) {
                File file = ((FileOutputOptions) outputOptions).getFile();
                if (!OutputUtil.createParentFolder(file)) {
                    Logger.w(Recorder.TAG, "Failed to create folder for " + file.getAbsolutePath());
                }
                Logger.d(Recorder.TAG, "Muxer.setOutput by path = " + file.getAbsolutePath());
                muxerCreate.setOutput(file.getAbsolutePath(), i);
                uriInsert = Uri.fromFile(file);
            } else if (outputOptions instanceof FileDescriptorOutputOptions) {
                Logger.d(Recorder.TAG, "Muxer.setOutput by ParcelFileDescriptor");
                muxerCreate.setOutput(parcelFileDescriptor, i);
            } else if (outputOptions instanceof MediaStoreOutputOptions) {
                MediaStoreOutputOptions mediaStoreOutputOptions = (MediaStoreOutputOptions) outputOptions;
                try {
                    uriInsert = mediaStoreOutputOptions.getContentResolver().insert(mediaStoreOutputOptions.getCollectionUri(), resolveContentValues(mediaStoreOutputOptions, muxerCreate));
                    if (uriInsert == null) {
                        throw new IOException("Unable to create MediaStore entry.");
                    }
                    if (Build.VERSION.SDK_INT < 26) {
                        String absolutePathFromUri = OutputUtil.getAbsolutePathFromUri(mediaStoreOutputOptions.getContentResolver(), uriInsert, Recorder.MEDIA_COLUMN);
                        if (absolutePathFromUri == null) {
                            throw new IOException("Unable to get path from uri " + uriInsert);
                        }
                        if (!OutputUtil.createParentFolder(new File(absolutePathFromUri))) {
                            Logger.w(Recorder.TAG, "Failed to create folder for " + absolutePathFromUri);
                        }
                        Logger.d(Recorder.TAG, "Muxer.setOutput by path = " + absolutePathFromUri);
                        muxerCreate.setOutput(absolutePathFromUri, i);
                    } else {
                        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = mediaStoreOutputOptions.getContentResolver().openFileDescriptor(uriInsert, "rw");
                        if (parcelFileDescriptorOpenFileDescriptor == null) {
                            throw new IOException("Unable to open file descriptor from uri " + uriInsert);
                        }
                        try {
                            Logger.d(Recorder.TAG, "Muxer.setOutput by ParcelFileDescriptor");
                            muxerCreate.setOutput(parcelFileDescriptorOpenFileDescriptor, i);
                        } catch (IOException e) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                            throw e;
                        }
                    }
                } catch (RuntimeException e2) {
                    throw new IOException("Unable to create MediaStore entry by " + e2, e2);
                }
            } else {
                throw new AssertionError("Invalid output options type: " + outputOptions.getClass().getSimpleName());
            }
            consumer.accept(uriInsert);
            return muxerCreate;
        }

        static /* synthetic */ void lambda$initializeRecording$2(MediaStoreOutputOptions mediaStoreOutputOptions, Uri uri) {
            if (uri.equals(Uri.EMPTY)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_pending", (Integer) 0);
            mediaStoreOutputOptions.getContentResolver().update(uri, contentValues, null, null);
        }

        static /* synthetic */ void lambda$initializeRecording$4(MediaStoreOutputOptions mediaStoreOutputOptions, Context context, Uri uri) throws Throwable {
            if (uri.equals(Uri.EMPTY)) {
                return;
            }
            String absolutePathFromUri = OutputUtil.getAbsolutePathFromUri(mediaStoreOutputOptions.getContentResolver(), uri, Recorder.MEDIA_COLUMN);
            if (absolutePathFromUri != null) {
                MediaScannerConnection.scanFile(context, new String[]{absolutePathFromUri}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: androidx.camera.video.Recorder$RecordingRecord$$ExternalSyntheticLambda0
                    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                    public final void onScanCompleted(String str, Uri uri2) {
                        Recorder.RecordingRecord.lambda$initializeRecording$3(str, uri2);
                    }
                });
                return;
            }
            Logger.d(Recorder.TAG, "Skipping media scanner scan. Unable to retrieve file path from URI: " + uri);
        }

        static /* synthetic */ void lambda$initializeRecording$3(String str, Uri uri) {
            if (uri == null) {
                Logger.e(Recorder.TAG, String.format("File scanning operation failed [path: %s]", str));
            } else {
                Logger.d(Recorder.TAG, String.format("File scan completed successfully [path: %s, URI: %s]", str, uri));
            }
        }

        private ContentValues resolveContentValues(MediaStoreOutputOptions mediaStoreOutputOptions, Muxer muxer) {
            ContentValues contentValues = new ContentValues(mediaStoreOutputOptions.getContentValues());
            if (Build.VERSION.SDK_INT >= 29 && !muxer.isInterruptionResilient()) {
                contentValues.put("is_pending", (Integer) 1);
            }
            return contentValues;
        }

        private static AudioSourceSupplier getAudioSourceSupplier(final Context context) {
            if (Build.VERSION.SDK_INT < 31) {
                context = null;
            }
            return new AudioSourceSupplier() { // from class: androidx.camera.video.Recorder.RecordingRecord.1
                @Override // androidx.camera.video.Recorder.RecordingRecord.AudioSourceSupplier
                public AudioSource get(AudioSettings audioSettings, Executor executor) throws AudioSourceAccessException {
                    return new AudioSource(audioSettings, executor, context);
                }
            };
        }

        void updateVideoRecordEvent(VideoRecordEvent videoRecordEvent) {
            updateVideoRecordEvent(videoRecordEvent, true);
        }

        void updateVideoRecordEvent(final VideoRecordEvent videoRecordEvent, boolean z) {
            if (!Objects.equals(videoRecordEvent.getOutputOptions(), getOutputOptions())) {
                throw new AssertionError("Attempted to update event listener with event from incorrect recording [Recording: " + videoRecordEvent.getOutputOptions() + ", Expected: " + getOutputOptions() + "]");
            }
            if (z) {
                String str = "Sending VideoRecordEvent " + videoRecordEvent.getClass().getSimpleName();
                if (videoRecordEvent instanceof VideoRecordEvent.Finalize) {
                    VideoRecordEvent.Finalize finalize = (VideoRecordEvent.Finalize) videoRecordEvent;
                    if (finalize.hasError()) {
                        str = str + String.format(" [error: %s]", VideoRecordEvent.Finalize.errorToString(finalize.getError()));
                    }
                }
                Logger.d(Recorder.TAG, str);
            }
            updateRecordingState(videoRecordEvent);
            if (getCallbackExecutor() == null || getEventListener() == null) {
                return;
            }
            try {
                getCallbackExecutor().execute(new Runnable() { // from class: androidx.camera.video.Recorder$RecordingRecord$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m1182xd9bc10d1(videoRecordEvent);
                    }
                });
            } catch (RejectedExecutionException e) {
                Logger.e(Recorder.TAG, "The callback executor is invalid.", e);
            }
        }

        /* JADX INFO: renamed from: lambda$updateVideoRecordEvent$5$androidx-camera-video-Recorder$RecordingRecord, reason: not valid java name */
        /* synthetic */ void m1182xd9bc10d1(VideoRecordEvent videoRecordEvent) {
            getEventListener().accept(videoRecordEvent);
        }

        private void updateRecordingState(VideoRecordEvent videoRecordEvent) {
            if ((videoRecordEvent instanceof VideoRecordEvent.Start) || (videoRecordEvent instanceof VideoRecordEvent.Resume)) {
                this.mRecordingState.setState(true);
            } else if ((videoRecordEvent instanceof VideoRecordEvent.Pause) || (videoRecordEvent instanceof VideoRecordEvent.Finalize)) {
                this.mRecordingState.setState(false);
            }
        }

        StateObservable<Boolean> getRecordingState() {
            return this.mRecordingState;
        }

        AudioSource performOneTimeAudioSourceCreation(AudioSettings audioSettings) throws AudioSourceAccessException {
            if (!hasAudioEnabled()) {
                throw new AssertionError("Recording does not have audio enabled. Unable to create audio source for recording " + this);
            }
            AudioSourceSupplier andSet = this.mAudioSourceSupplier.getAndSet(null);
            if (andSet != null) {
                return andSet.get(audioSettings, Recorder.AUDIO_EXECUTOR);
            }
            throw new AssertionError("One-time audio source creation has already occurred for recording " + this);
        }

        Muxer performOneTimeMuxerCreation(int i, Consumer<Uri> consumer) throws IOException {
            if (!this.mInitialized.get()) {
                throw new AssertionError("Recording " + this + " has not been initialized");
            }
            MuxerSupplier andSet = this.mMuxerSupplier.getAndSet(null);
            if (andSet == null) {
                throw new AssertionError("One-time muxer creation has already occurred for recording " + this);
            }
            try {
                return andSet.get(i, consumer);
            } catch (RuntimeException e) {
                throw new IOException("Failed to create Muxer by " + e, e);
            }
        }

        void finalizeRecording(Uri uri) {
            if (this.mInitialized.get()) {
                finalizeRecordingInternal(this.mRecordingFinalizer.getAndSet(null), uri);
            }
        }

        void mute(boolean z) {
            this.mMuted.set(z);
        }

        boolean isMuted() {
            return this.mMuted.get();
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            finalizeRecording(Uri.EMPTY);
        }

        protected void finalize() throws Throwable {
            try {
                this.mCloseGuard.warnIfOpen();
                Consumer<Uri> andSet = this.mRecordingFinalizer.getAndSet(null);
                if (andSet != null) {
                    finalizeRecordingInternal(andSet, Uri.EMPTY);
                }
            } finally {
                super.finalize();
            }
        }

        private void finalizeRecordingInternal(Consumer<Uri> consumer, Uri uri) {
            if (consumer == null) {
                throw new AssertionError("Recording " + this + " has already been finalized");
            }
            this.mCloseGuard.close();
            consumer.accept(uri);
        }
    }

    public static final class Builder {
        private int mVideoCapabilitiesSource = 0;
        private Executor mExecutor = null;
        private EncoderFactory mVideoEncoderFactory = Recorder.DEFAULT_ENCODER_FACTORY;
        private EncoderFactory mAudioEncoderFactory = Recorder.DEFAULT_ENCODER_FACTORY;
        private MuxerFactory mMuxerFactory = Recorder.DEFAULT_MUXER_FACTORY;
        private OutputStorage.Factory mOutputStorageFactory = Recorder.OUTPUT_STORAGE_FACTORY_DEFAULT;
        private long mRequiredFreeStorageBytes = -1;
        private final MediaSpec.Builder mMediaSpecBuilder = Recorder.MEDIA_SPEC_DEFAULT.toBuilder();

        public Builder setExecutor(Executor executor) {
            Preconditions.checkNotNull(executor, "The specified executor can't be null.");
            this.mExecutor = executor;
            return this;
        }

        public Builder setQualitySelector(final QualitySelector qualitySelector) {
            Preconditions.checkNotNull(qualitySelector, "The specified quality selector can't be null.");
            this.mMediaSpecBuilder.configureVideo(new Consumer() { // from class: androidx.camera.video.Recorder$Builder$$ExternalSyntheticLambda3
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((VideoSpec.Builder) obj).setQualitySelector(qualitySelector);
                }
            });
            return this;
        }

        public Builder setMuxerFactory(MuxerFactory muxerFactory) {
            this.mMuxerFactory = muxerFactory;
            return this;
        }

        public Builder setVideoCapabilitiesSource(int i) {
            boolean z = true;
            if (i != 0 && i != 1) {
                z = false;
            }
            Preconditions.checkArgument(z, "Not a supported video capabilities source: " + i);
            this.mVideoCapabilitiesSource = i;
            return this;
        }

        public Builder setTargetVideoEncodingBitRate(final int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The requested target bitrate " + i + " is not supported. Target bitrate must be greater than 0.");
            }
            this.mMediaSpecBuilder.configureVideo(new Consumer() { // from class: androidx.camera.video.Recorder$Builder$$ExternalSyntheticLambda0
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((VideoSpec.Builder) obj).setBitrate(i);
                }
            });
            return this;
        }

        public Builder setAspectRatio(final int i) {
            this.mMediaSpecBuilder.configureVideo(new Consumer() { // from class: androidx.camera.video.Recorder$Builder$$ExternalSyntheticLambda2
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((VideoSpec.Builder) obj).setAspectRatio(i);
                }
            });
            return this;
        }

        public Builder setRequiredFreeStorageBytes(long j) {
            Preconditions.checkArgument(j > 0);
            this.mRequiredFreeStorageBytes = j;
            return this;
        }

        public Builder setAudioSource(final int i) {
            this.mMediaSpecBuilder.configureAudio(new Consumer() { // from class: androidx.camera.video.Recorder$Builder$$ExternalSyntheticLambda1
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((AudioSpec.Builder) obj).setSource(i);
                }
            });
            return this;
        }

        Builder setVideoEncoderFactory(EncoderFactory encoderFactory) {
            this.mVideoEncoderFactory = encoderFactory;
            return this;
        }

        Builder setAudioEncoderFactory(EncoderFactory encoderFactory) {
            this.mAudioEncoderFactory = encoderFactory;
            return this;
        }

        Builder setOutputStorageFactory(OutputStorage.Factory factory) {
            this.mOutputStorageFactory = factory;
            return this;
        }

        public Recorder build() {
            return new Recorder(this.mExecutor, this.mMediaSpecBuilder.build(), this.mVideoCapabilitiesSource, this.mVideoEncoderFactory, this.mAudioEncoderFactory, this.mMuxerFactory, this.mOutputStorageFactory, this.mRequiredFreeStorageBytes);
        }
    }
}
