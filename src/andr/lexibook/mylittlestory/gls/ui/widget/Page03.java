package andr.lexibook.mylittlestory.gls.ui.widget;

import andr.lexibook.mylittlestory.gls.ui.R;
import andr.lexibook.mylittlestory.gls.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.gls.ui.ViewIml.PageView;
import android.content.Context;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
public class Page03 extends PageView {


    private GifMovieView girl;
    private GifMovieView sky;

    public Page03(Context context) {
        super(context, R.layout.page03);
        girl = (GifMovieView) page.findViewById(R.id.gif_p03_girl);
        sky = (GifMovieView) page.findViewById(R.id.gif_p03_sky);

        girl.setMovieAsset(ctx.getString(R.string.p03_girl));
        sky.setMovieAsset(ctx.getString(R.string.p03_sky));

        layout = (AbsoluteLayout) page.findViewById(R.id.ll_p03_bg);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(2));
        //dynamic
        params = (AbsoluteLayout.LayoutParams) layout.getLayoutParams();
        params.width = (int) getWinWidth();
        params.height = (int) getWinHeight();
        layout.setLayoutParams(params);
        sky.setLayoutParams(params);

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_y));
            params.width = (int) (getWidthScale() * 45);
            params.height = (int) (getWidthScale() * 45);
            pause.setLayoutParams(params);
        }
    }

    @Override
    public void Clear() {
        super.Clear();
        girl.Clear();
        sky.Clear();
    }
}
