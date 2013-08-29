package andr.lexibook.mylittlestory.gls.ui;

import andr.lexibook.mylittlestory.gls.control.BgSrc;
import andr.lexibook.mylittlestory.gls.control.PageFactory;
import andr.lexibook.mylittlestory.gls.libs.FlipViewController;
import andr.lexibook.mylittlestory.gls.model.FlipAdapter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;

import java.io.IOException;

/**
 * User: rain
 * Date: 4/23/13
 * Time: 8:05 PM
 */
@SuppressWarnings("deprecation")
public class Pages extends BaseActivity implements PageFactory.Callback, FlipViewController.PlayPauseCallBack {

    private FlipViewController flipView;
    private boolean isFirst = true;
    private int position = 0;
    private Fliplistener flipListener;
    private MediaPlayer.OnCompletionListener langCompleteListener;
    private MediaPlayer.OnCompletionListener pageCompleteListener;
    private FlipAdapter flipAdapter;
    private PageFactory pageFactory;
    /**
     * add play & pause
     */
    protected Handler mHandler;
    protected TimerThread mTimerThead;
    protected boolean ifAllowFlip = false;
    protected boolean isPaused = false;
    protected boolean isPrepared = false;

    private ImageView ll_play;
    private ImageView ll_pause;
    private AbsoluteLayout.LayoutParams params;
    private View preView;
    private AbsoluteLayout al_pages;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pages);
        bgSrc = BgSrc.getInstance(this);
        pageFactory = PageFactory.getInstance(this);
        al_pages = (AbsoluteLayout) findViewById(R.id.al_pages);

        flipView = new FlipViewController(this, FlipViewController.HORIZONTAL);
        flipView.setPlayPauseCallBack(this);
        flipAdapter = new FlipAdapter(this);
        flipView.setAdapter(flipAdapter);
        al_pages.addView(flipView);

//        setting.setAuto(false);
        flipListener = new Fliplistener();
        flipView.setFlipByTouchEnabled(true);
        flipView.setOnViewFlipListener(flipListener);

        if (setting.getReadMode().isAuto()) {
            langCompleteListener = new LangListener();
            pageCompleteListener = new PageListener();
//            flipView.setFlipByTouchEnabled(false);
            if (isFirst) {
                mPlayer = mediaFactory.getPage01();
                mPlayer.setOnCompletionListener(pageCompleteListener);
                try {
                    mPlayer.prepare();
                    isPrepared = true;
                    mPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                isFirst = false;
            }
        }
        pageFactory.setCallback(this);
        mHandler = new Handler();
        mTimerThead = new TimerThread();


        if (setting.isAuto()) {
            ll_play = new ImageView(this);
            ll_pause = new ImageView(this);
            ll_play.setBackgroundDrawable(bgSrc.getPlayDrawable());
            ll_pause.setBackgroundDrawable(bgSrc.getPauseDrawable());
            params = new AbsoluteLayout.LayoutParams(45, 45, 678, 419);
            params.x = (int) (getWidthScale() * getResources().getDimension(R.dimen.btn_play_pause_x));
            params.y = (int) (getHeightScale() * getResources().getDimension(R.dimen.btn_play_pause_y));
            params.width = (int) (getWidthScale() * 45);
            params.height = (int) (getWidthScale() * 45);
            ll_play.setLayoutParams(params);
            ll_pause.setLayoutParams(params);
        }

        setMenuView(findViewById(R.id.any_widget_4_menu_pages));
    }

    @Override
    public void pauseOrPlay(View view, MotionEvent e) {
        preView = view;
        if (setting.isAuto() && (position >= 0 && position < 11)
                && (e.getAction() == MotionEvent.ACTION_DOWN
                && checkLocation(e, getResources().getIntArray(R.array.btn_play_pause)))) {
            if (ll_pause.getParent() != null)
                ((AbsoluteLayout) ll_pause.getParent()).removeView(ll_pause);
            if (ll_play.getParent() != null)
                ((AbsoluteLayout) ll_play.getParent()).removeView(ll_play);
            if (isPaused) {
                ll_pause.setLayoutParams(params);
                ((AbsoluteLayout) view).addView(ll_pause);
                isPaused = false;
                if (isPrepared)
                    mPlayer.start();
            } else {
                ll_play.setLayoutParams(params);
                ((AbsoluteLayout) view).addView(ll_play);
                try {
                    mPlayer.pause();
                    isPaused = true;
                } catch (Exception ePause) {
                    System.out.println("ePause: " + ePause.getCause());
                }
            }
        }
    }


    @Override
    public void onFliped(View view) {
        if (preView != null) {
            if (ll_play.getParent() != null)
                ((AbsoluteLayout) ll_play.getParent()).removeView(ll_play);
        }
    }

    @Override
    public void startFlip(View view) {
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.release();
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (mPlayer != null && mPlayer.isPlaying())
                mPlayer.release();
            toPage(Menu.class);
        }
        return false;
    }

    @Override
    public void setLanguage(int langId) {
        super.setLanguage(langId);
        if (setting.getReadMode().isAuto()) {
            mPlayer.release();
            langPlayer.setOnCompletionListener(langCompleteListener);
        }
        if (langChanged) {
            pageFactory.getPage(this.position).getLayoutView().setBackgroundResource(bgSrc.setLang(langId).getPageDrawableId(this.position));
            flipAdapter.notifyDataSetChanged();
            flipView.flipToPageAgain();
            langChanged = false;
        }
    }

    private void play(int position) {
        this.position = position;
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
            System.gc();
        }
        switch (position) {
            case 0:
                mPlayer = mediaFactory.getPage01();
                break;
            case 1:
                mPlayer = mediaFactory.getPage02();
                break;
            case 2:
                mPlayer = mediaFactory.getPage03();
                break;
            case 3:
                mPlayer = mediaFactory.getPage04();
                break;
            case 4:
                mPlayer = mediaFactory.getPage05();
                break;
            case 5:
                mPlayer = mediaFactory.getPage06();
                break;
            case 6:
                mPlayer = mediaFactory.getPage07();
                break;
            case 7:
                mPlayer = mediaFactory.getPage08();
                break;
            case 8:
                mPlayer = mediaFactory.getPage09();
                break;
            case 9:
                mPlayer = mediaFactory.getPage10();
                break;
            case 10:
                mPlayer = mediaFactory.getPage11();
                break;
            case 11:
                mPlayer = mediaFactory.getPage12();
                break;
        }
        try {
            mPlayer.setOnCompletionListener(pageCompleteListener);
            mPlayer.prepare();
            isPrepared = true;
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPosition(int posit) {
        this.position = posit;
    }

    @Override
    public void autoFlip() {
        flipView.autoFlip();
        flipView.setFlipByTouchEnabled(true);
    }

    @Override
    public void diableFlip() {
        flipView.setFlipByTouchEnabled(false);
    }

    @SuppressWarnings("deprecation")
    class Fliplistener implements FlipViewController.ViewFlipListener {

        @Override
        public void onViewFlipped(View view, int position) {
            isPaused = false;
            isPrepared = false;

            if (setting.isAuto() && (position >= 0 && position < 11)) {
                params.x = (int) (getWidthScale() * getResources().getDimension(R.dimen.btn_play_pause_x));
                params.y = (int) (getHeightScale() * getResources().getDimension(R.dimen.btn_play_pause_y));
                params.width = (int) (getWidthScale() * 45);
                params.height = (int) (getWidthScale() * 45);
            }

            /**
             * about slowwer
             */
            mHandler.postDelayed(mTimerThead, 1000);
            flipView.setFlipByTouchEnabled(false);

            setPosition(position);
            if (setting.getReadMode().isAuto() && !langChanged)
                play(position);
        }
    }

    class TimerThread implements Runnable {

        @Override
        public void run() {
            (Pages.this).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    timer();
                }
            });
        }

    }


    protected void timer() {
        if (!ifAllowFlip) {
            flipView.setFlipByTouchEnabled(true);
        }
    }

    class LangListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            play(position);
        }
    }

    class PageListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (!isPaused && position >= 0 && position < 11 && !setting.isOOM()) {
                flipView.autoFlip();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Pages onResume ");
        flipView.onResume();
        if (isPaused) {
            isPaused = false;
            if (isPrepared) {
                mPlayer.start();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Pages onPause ");
        if (mPlayer != null) {
            try {
                mPlayer.pause();
                isPaused = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        flipView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Pages onStop ");
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
        isPaused = false;
        isPrepared = false;
    }

    @Override
    protected void onDestroy() {
        flipView.Clear();
        System.out.println("Pages OnDestroy ");
        super.onDestroy();
    }

}