package andr.lexibook.mylittlestory.gls.ui;

import andr.lexibook.mylittlestory.gls.control.BtnGifSrc;
import andr.lexibook.mylittlestory.gls.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.gls.ui.ViewIml.MenuGirlGif;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
@SuppressWarnings("deprecation")
public class Menu extends BaseActivity implements View.OnClickListener {

    private GifMovieView fa;
    private MenuGirlGif girl;
    private GifMovieView ma_bb;
    private GifMovieView btn_read_self;
    private GifMovieView btn_read_auto;
    private AbsoluteLayout.LayoutParams params;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        btnSrc = BtnGifSrc.getInstance(this);

        //init
        fa = (GifMovieView) findViewById(R.id.gif_menu_fa);
        girl = (MenuGirlGif) findViewById(R.id.gif_menu_girl);
        ma_bb = (GifMovieView) findViewById(R.id.gif_menu_ma_bb);
        btn_read_auto = (GifMovieView) findViewById(R.id.gif_menu_read_auto);
        btn_read_self = (GifMovieView) findViewById(R.id.gif_menu_read_self);

        fa.setMovieAsset(getString(R.string.menu_fa));
        girl.setMovieAsset(getString(R.string.menu_girl));
        ma_bb.setMovieAsset(getString(R.string.menu_ma_bb));
        btn_read_auto.setMovieAsset(btnSrc.setLang(setting.getLangId()).getMenuAuto());
        btn_read_self.setMovieAsset(btnSrc.setLang(setting.getLangId()).getMenuSelf());

        params = (AbsoluteLayout.LayoutParams) btn_read_auto.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.menu_read_auto_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.menu_read_auto_y));
        btn_read_auto.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) btn_read_self.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.menu_read_self_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.menu_read_self_y));
        btn_read_self.setLayoutParams(params);


        //set listener
        btn_read_auto.setOnClickListener(this);
        btn_read_self.setOnClickListener(this);

        //
        girl.setMenuCallBack(this);
        setMenuView(findViewById(R.id.any_widget_4_menu));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gif_menu_read_auto:
                setReadMode(true);
                break;
            case R.id.gif_menu_read_self:
                setReadMode(false);
                break;
            default:
                break;
        }
        girl.releasePlay();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toPage(Pages.class);
            }
        }, 2000);
    }

    @Override
    public void setLanguage(int langId) {
        super.setLanguage(langId);
        /**
         *  here need to change menu button suitted language
         */
        btn_read_auto.setMovieAsset(btnSrc.setLang(langId).getMenuAuto());
        btn_read_self.setMovieAsset(btnSrc.setLang(langId).getMenuSelf());
        /**
         * set player
         */
        girl.changLanguage();
    }

    @Override
    protected void onPause() {
        super.onPause();
        girl.releasePlay();
    }

    @Override
    protected void onDestroy() {
        fa.Clear();
        girl.Clear();
        ma_bb.Clear();
        btn_read_self.Clear();
        btn_read_auto.Clear();
        super.onDestroy();
    }

}
