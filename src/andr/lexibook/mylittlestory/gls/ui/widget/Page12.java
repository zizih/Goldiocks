package andr.lexibook.mylittlestory.gls.ui.widget;

import andr.lexibook.mylittlestory.gls.control.BtnGifSrc;
import andr.lexibook.mylittlestory.gls.ui.Menu;
import andr.lexibook.mylittlestory.gls.ui.R;
import andr.lexibook.mylittlestory.gls.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.gls.ui.ViewIml.PageView;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
public class Page12 extends PageView implements View.OnClickListener {

    private GifMovieView btn_menu;
    private GifMovieView btn_quit;
    private GifMovieView flower;
    private GifMovieView girl;
    private GifMovieView sky;
    private Intent menuIntent;
    public BtnGifSrc btnSrc;


    public Page12(Context context) {
        super(context, R.layout.page12);
        menuIntent = new Intent();
        menuIntent.setClass(context, Menu.class);

        flower = (GifMovieView) page.findViewById(R.id.gif_p12_flower);
        girl = (GifMovieView) page.findViewById(R.id.gif_p12_girl);
        sky = (GifMovieView) page.findViewById(R.id.gif_p12_sky);
        btn_menu = (GifMovieView) page.findViewById(R.id.gif_p12_btn_menu);
        btn_quit = (GifMovieView) page.findViewById(R.id.gif_p12_btn_quit);

        btnSrc = BtnGifSrc.getInstance(context);
        btn_menu.setMovieAsset(btnSrc.setLang(setting.getLangId()).getMenuBack());
        btn_quit.setMovieAsset(btnSrc.setLang(setting.getLangId()).getQuit());
        flower.setMovieAsset(ctx.getString(R.string.p12_flower));
        girl.setMovieAsset(ctx.getString(R.string.p12_girl));
        sky.setMovieAsset(ctx.getString(R.string.p12_sky));

        params = (AbsoluteLayout.LayoutParams) btn_menu.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p12_btn_menu_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p12_btn_menu_y));
        btn_menu.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) btn_quit.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p12_btn_quit_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p12_btn_quit_y));
        btn_quit.setLayoutParams(params);

        btn_menu.setOnClickListener(this);
        btn_quit.setOnClickListener(this);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p12);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(11));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gif_p12_btn_menu:
                ctx.startActivity(menuIntent);
                ctx.finish();
                System.gc();
                break;
            case R.id.gif_p12_btn_quit:
                ctx.finish();
                System.exit(0);
                break;
        }
    }

}
