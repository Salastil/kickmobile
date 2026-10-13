package com.amazonaws.ivs.player;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.timepicker.TimeModel;
import io.ktor.sse.ServerSentEventKt;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes5.dex */
public class PlayerControlView extends LinearLayout implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private TextView durationText;
    private ImageButton playPauseButton;
    private Player player;
    private Handler positionHandler;
    private TextView positionText;
    private SeekBar seekBar;
    private Handler visibilityHandler;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    public PlayerControlView(Context context) {
        super(context);
        initialize();
    }

    public PlayerControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize();
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize();
    }

    public SeekBar getSeekBar() {
        return this.seekBar;
    }

    public TextView getPositionTextView() {
        return this.positionText;
    }

    public TextView getDurationTextView() {
        return this.durationText;
    }

    public ImageButton getPlayButton() {
        return this.playPauseButton;
    }

    private void initialize() {
        setOrientation(1);
        setBackgroundColor(-16777216);
        getBackground().setAlpha(200);
        this.visibilityHandler = new Handler(new Handler.Callback() { // from class: com.amazonaws.ivs.player.PlayerControlView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                PlayerControlView.this.setVisibility(message.what);
                return true;
            }
        });
        this.positionHandler = new Handler(new Handler.Callback() { // from class: com.amazonaws.ivs.player.PlayerControlView.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                PlayerControlView.this.updateControls();
                return false;
            }
        });
        SeekBar seekBar = new SeekBar(getContext());
        this.seekBar = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.positionText = new TextView(getContext());
        this.durationText = new TextView(getContext());
        this.positionText.setTextAppearance(android.R.style.TextAppearance.DeviceDefault.Medium);
        this.durationText.setTextAppearance(android.R.style.TextAppearance.DeviceDefault.Medium);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        ImageButton imageButton = new ImageButton(getContext());
        this.playPauseButton = imageButton;
        imageButton.setOnClickListener(this);
        this.playPauseButton.setBackground(null);
        addView(this.playPauseButton, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        addView(initializeTimeline(), layoutParams2);
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.amazonaws.ivs.player.PlayerControlView.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                PlayerControlView.this.updateControls();
            }
        });
    }

    private LinearLayout initializeTimeline() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        int iApplyDimension = (int) TypedValue.applyDimension(2, 10.0f, getContext().getResources().getDisplayMetrics());
        linearLayout.setPadding(iApplyDimension, iApplyDimension, 0, iApplyDimension * 3);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = NavigationBarView.ITEM_GRAVITY_START_CENTER;
        linearLayout.addView(this.positionText, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        layoutParams2.weight = 1.0f;
        layoutParams2.setMargins(iApplyDimension, iApplyDimension, iApplyDimension, iApplyDimension);
        linearLayout.addView(this.seekBar, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 8388629;
        linearLayout.addView(this.durationText, layoutParams3);
        return linearLayout;
    }

    public void setPlayer(Player player) {
        this.player = player;
        updateControls();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateControls() {
        Player player = this.player;
        if (player == null) {
            return;
        }
        long duration = player.getDuration();
        long position = this.player.getPosition();
        SeekBar seekBar = this.seekBar;
        if (duration == -1) {
            seekBar.setVisibility(4);
            this.durationText.setVisibility(4);
        } else {
            seekBar.setVisibility(0);
            this.seekBar.setMax((int) duration);
            this.seekBar.setProgress((int) position);
            this.durationText.setVisibility(0);
            this.durationText.setText(getDurationString(duration));
        }
        this.positionText.setText(getDurationString(position));
        Player.State state = this.player.getState();
        if (state == Player.State.PLAYING) {
            this.playPauseButton.setImageResource(android.R.drawable.ic_media_pause);
        } else if (state == Player.State.IDLE || state == Player.State.ENDED) {
            this.playPauseButton.setImageResource(android.R.drawable.ic_media_play);
        }
        if (isAttachedToWindow()) {
            this.positionHandler.removeMessages(0);
            this.positionHandler.sendEmptyMessageDelayed(0, 200L);
        }
    }

    private static String getDurationString(long j) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long j2 = j / DurationKt.MILLIS_IN_HOUR;
        long millis = j - TimeUnit.HOURS.toMillis(j2);
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        long j3 = millis / DurationKt.MILLIS_IN_MINUTE;
        long millis2 = millis - TimeUnit.MINUTES.toMillis(j3);
        TimeUnit timeUnit3 = TimeUnit.MILLISECONDS;
        long j4 = millis2 / 1000;
        TimeUnit.SECONDS.toMillis(j4);
        StringBuilder sb = new StringBuilder();
        if (j2 > 0) {
            sb.append(String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, Long.valueOf(j2)));
            sb.append(ServerSentEventKt.COLON);
        }
        sb.append(String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, Long.valueOf(j3)));
        sb.append(ServerSentEventKt.COLON);
        sb.append(String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, Long.valueOf(j4)));
        return sb.toString();
    }

    public void showControls(boolean z) {
        this.visibilityHandler.removeMessages(4);
        this.visibilityHandler.removeMessages(0);
        if (z) {
            setVisibility(0);
            this.visibilityHandler.sendMessageDelayed(this.visibilityHandler.obtainMessage(4), 5000L);
            return;
        }
        setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Player player = this.player;
        if (player != null) {
            Player.State state = player.getState();
            if (state == Player.State.PLAYING || state == Player.State.BUFFERING) {
                this.player.pause();
            } else {
                this.player.play();
            }
        }
        showControls(true);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        showControls(true);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Player player = this.player;
        if (player != null) {
            long duration = player.getDuration();
            long progress = seekBar.getProgress();
            if (duration <= 0 || progress > duration) {
                return;
            }
            this.player.seekTo(progress);
        }
    }
}
