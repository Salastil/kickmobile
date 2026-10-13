package com.amazonaws.ivs.player;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class PlayerView extends FrameLayout implements SurfaceHolder.Callback, View.OnAttachStateChangeListener {
    private AudioFocusHandler audioFocusHandler;
    private boolean captionsEnabled;
    private TextView captionsView;
    private boolean controlsEnabled;
    private PlayerControlView controlsView;
    private Uri mediaUri;
    private Player player;
    private final Player.Listener playerListener;
    private ProgressBar progressView;
    private ResizeMode resizeMode;
    private Surface surface;
    private SurfaceView surfaceView;
    private int videoHeight;
    private int videoWidth;

    public PlayerView(Context context) {
        super(context);
        this.playerListener = new Player.Listener() { // from class: com.amazonaws.ivs.player.PlayerView.1
            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onAnalyticsEvent(String str, String str2) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onDurationChanged(long j) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onError(PlayerException playerException) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onMetadata(String str, ByteBuffer byteBuffer) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onQualityChanged(Quality quality) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onRebuffering() {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onSeekCompleted(long j) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onSourceGroupChanged(SourceGroup sourceGroup) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onCue(Cue cue) {
                if ((cue instanceof TextCue) && PlayerView.this.captionsEnabled) {
                    PlayerView.this.captionsView.setText(((TextCue) cue).text);
                }
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onStateChanged(Player.State state) {
                int i = AnonymousClass3.$SwitchMap$com$amazonaws$ivs$player$Player$State[state.ordinal()];
                if (i == 1) {
                    PlayerView.this.progressView.setVisibility(0);
                    return;
                }
                if (i == 2) {
                    PlayerView.this.captionsView.setText("");
                    PlayerView.this.player.play();
                    PlayerView.this.progressView.setVisibility(4);
                } else {
                    if (i == 3) {
                        PlayerView.this.progressView.setVisibility(4);
                        return;
                    }
                    if (i == 4) {
                        PlayerView.this.progressView.setVisibility(4);
                        PlayerView.this.audioFocusHandler.requestFocus();
                    } else {
                        if (i != 5) {
                            return;
                        }
                        PlayerView.this.captionsView.setText("");
                        PlayerView.this.progressView.setVisibility(4);
                        PlayerView.this.audioFocusHandler.abandonFocus();
                    }
                }
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onVideoSizeChanged(int i, int i2) {
                PlayerView.this.videoWidth = i;
                PlayerView.this.videoHeight = i2;
                PlayerView.this.resizeMode.setLayoutParams(PlayerView.this.surfaceView, i, i2);
            }
        };
        initialize();
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.playerListener = new Player.Listener() { // from class: com.amazonaws.ivs.player.PlayerView.1
            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onAnalyticsEvent(String str, String str2) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onDurationChanged(long j) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onError(PlayerException playerException) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onMetadata(String str, ByteBuffer byteBuffer) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onQualityChanged(Quality quality) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onRebuffering() {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onSeekCompleted(long j) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onSourceGroupChanged(SourceGroup sourceGroup) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onCue(Cue cue) {
                if ((cue instanceof TextCue) && PlayerView.this.captionsEnabled) {
                    PlayerView.this.captionsView.setText(((TextCue) cue).text);
                }
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onStateChanged(Player.State state) {
                int i = AnonymousClass3.$SwitchMap$com$amazonaws$ivs$player$Player$State[state.ordinal()];
                if (i == 1) {
                    PlayerView.this.progressView.setVisibility(0);
                    return;
                }
                if (i == 2) {
                    PlayerView.this.captionsView.setText("");
                    PlayerView.this.player.play();
                    PlayerView.this.progressView.setVisibility(4);
                } else {
                    if (i == 3) {
                        PlayerView.this.progressView.setVisibility(4);
                        return;
                    }
                    if (i == 4) {
                        PlayerView.this.progressView.setVisibility(4);
                        PlayerView.this.audioFocusHandler.requestFocus();
                    } else {
                        if (i != 5) {
                            return;
                        }
                        PlayerView.this.captionsView.setText("");
                        PlayerView.this.progressView.setVisibility(4);
                        PlayerView.this.audioFocusHandler.abandonFocus();
                    }
                }
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onVideoSizeChanged(int i, int i2) {
                PlayerView.this.videoWidth = i;
                PlayerView.this.videoHeight = i2;
                PlayerView.this.resizeMode.setLayoutParams(PlayerView.this.surfaceView, i, i2);
            }
        };
        initialize();
    }

    public PlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.playerListener = new Player.Listener() { // from class: com.amazonaws.ivs.player.PlayerView.1
            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onAnalyticsEvent(String str, String str2) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onDurationChanged(long j) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onError(PlayerException playerException) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onMetadata(String str, ByteBuffer byteBuffer) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onQualityChanged(Quality quality) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onRebuffering() {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onSeekCompleted(long j) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onSourceGroupChanged(SourceGroup sourceGroup) {
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onCue(Cue cue) {
                if ((cue instanceof TextCue) && PlayerView.this.captionsEnabled) {
                    PlayerView.this.captionsView.setText(((TextCue) cue).text);
                }
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onStateChanged(Player.State state) {
                int i2 = AnonymousClass3.$SwitchMap$com$amazonaws$ivs$player$Player$State[state.ordinal()];
                if (i2 == 1) {
                    PlayerView.this.progressView.setVisibility(0);
                    return;
                }
                if (i2 == 2) {
                    PlayerView.this.captionsView.setText("");
                    PlayerView.this.player.play();
                    PlayerView.this.progressView.setVisibility(4);
                } else {
                    if (i2 == 3) {
                        PlayerView.this.progressView.setVisibility(4);
                        return;
                    }
                    if (i2 == 4) {
                        PlayerView.this.progressView.setVisibility(4);
                        PlayerView.this.audioFocusHandler.requestFocus();
                    } else {
                        if (i2 != 5) {
                            return;
                        }
                        PlayerView.this.captionsView.setText("");
                        PlayerView.this.progressView.setVisibility(4);
                        PlayerView.this.audioFocusHandler.abandonFocus();
                    }
                }
            }

            @Override // com.amazonaws.ivs.player.Player.Listener
            public void onVideoSizeChanged(int i2, int i3) {
                PlayerView.this.videoWidth = i2;
                PlayerView.this.videoHeight = i3;
                PlayerView.this.resizeMode.setLayoutParams(PlayerView.this.surfaceView, i2, i3);
            }
        };
        initialize();
    }

    private void initialize() {
        this.controlsEnabled = true;
        this.audioFocusHandler = new AudioFocusHandler(getContext());
        this.resizeMode = ResizeMode.FIT;
        this.surfaceView = new SurfaceView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.surfaceView, layoutParams);
        this.surfaceView.getHolder().addCallback(this);
        TextView textView = new TextView(getContext());
        this.captionsView = textView;
        textView.setBackgroundColor(-16777216);
        this.captionsView.setTypeface(Typeface.MONOSPACE);
        this.captionsView.setTextSize(2, 24.0f);
        this.captionsView.setTextAlignment(4);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 81;
        addView(this.captionsView, layoutParams2);
        ProgressBar progressBar = new ProgressBar(getContext());
        this.progressView = progressBar;
        progressBar.setIndeterminate(true);
        this.progressView.setVisibility(4);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        addView(this.progressView, layoutParams3);
        this.controlsView = new PlayerControlView(getContext());
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.gravity = 80;
        addView(this.controlsView, layoutParams4);
        setPlayer(Player.Factory.create(getContext()));
        addOnAttachStateChangeListener(this);
    }

    public Player getPlayer() {
        return this.player;
    }

    private void setPlayer(Player player) {
        Player player2 = this.player;
        if (player2 != null) {
            player2.release();
        }
        this.player = player;
        player.addListener(this.playerListener);
        this.controlsView.setPlayer(player);
    }

    public PlayerControlView getControls() {
        return this.controlsView;
    }

    public boolean getCaptionsEnabled() {
        return this.captionsEnabled;
    }

    public void setCaptionsEnabled(boolean z) {
        this.captionsEnabled = z;
        this.captionsView.setVisibility(z ? 0 : 8);
    }

    public boolean getControlsEnabled() {
        return this.controlsEnabled;
    }

    public void setControlsEnabled(boolean z) {
        this.controlsEnabled = z;
        PlayerControlView playerControlView = this.controlsView;
        if (z) {
            playerControlView.setVisibility(0);
        } else {
            playerControlView.setVisibility(4);
        }
    }

    public Uri getMediaUri() {
        return this.mediaUri;
    }

    public void setMediaUri(Uri uri) {
        this.mediaUri = uri;
        Player player = this.player;
        if (player != null) {
            player.load(uri);
        }
    }

    public ResizeMode getResizeMode() {
        return this.resizeMode;
    }

    public void setResizeMode(ResizeMode resizeMode) {
        int i;
        this.resizeMode = resizeMode;
        int i2 = this.videoWidth;
        if (i2 <= 0 || (i = this.videoHeight) <= 0) {
            return;
        }
        resizeMode.setLayoutParams(this.surfaceView, i2, i);
    }

    public int getVolumeControlStream() {
        return this.audioFocusHandler.getVolumeControlStream();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (!zOnTouchEvent && this.controlsEnabled) {
            this.controlsView.showControls(true);
        }
        return zOnTouchEvent;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Player player = this.player;
        if (player != null) {
            if (i == 126) {
                player.play();
                return true;
            }
            if (i == 86 || i == 127) {
                player.pause();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Surface surface = surfaceHolder.getSurface();
        this.surface = surface;
        Player player = this.player;
        if (player != null) {
            player.setSurface(surface);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Player player = this.player;
        if (player != null && (player instanceof PlayerInternal) && ((PlayerInternal) player).getConfiguration().getBoolean(Configuration.Group.ADAPTIVE_BITRATE, "surfaceSizeFilterEnabled")) {
            ((PlayerInternal) this.player).setSurfaceSize(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.surface = null;
        Player player = this.player;
        if (player != null) {
            player.setSurface(null);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Uri uri = this.mediaUri;
        if (uri != null) {
            this.player.load(uri);
            this.player.play();
        }
        Surface surface = this.surface;
        if (surface != null) {
            this.player.setSurface(surface);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.progressView.setVisibility(4);
        this.audioFocusHandler.abandonFocus();
    }

    /* JADX INFO: renamed from: com.amazonaws.ivs.player.PlayerView$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$ivs$player$Player$State;

        static {
            int[] iArr = new int[Player.State.values().length];
            $SwitchMap$com$amazonaws$ivs$player$Player$State = iArr;
            try {
                iArr[Player.State.BUFFERING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$ivs$player$Player$State[Player.State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazonaws$ivs$player$Player$State[Player.State.IDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$amazonaws$ivs$player$Player$State[Player.State.PLAYING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$amazonaws$ivs$player$Player$State[Player.State.ENDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.surfaceView.post(new Runnable() { // from class: com.amazonaws.ivs.player.PlayerView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PlayerView.this.videoWidth <= 0 || PlayerView.this.videoHeight <= 0) {
                        return;
                    }
                    PlayerView.this.resizeMode.setLayoutParams(PlayerView.this.surfaceView, PlayerView.this.videoWidth, PlayerView.this.videoHeight);
                }
            });
        }
    }
}
