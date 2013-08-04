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
@SuppressWarnings("deprecation")
public class Page04 extends PageView {

    private GifMovieView fire;
    private GifMovieView girl;
    private GifMovieView smoke;


    private AbsoluteLayout p04_bg_up;

    public Page04(Context context) {
        super(context, R.layout.page04);

        fire = (GifMovieView) page.findViewById(R.id.gif_p04_fire);
        girl = (GifMovieView) page.findViewById(R.id.gif_p04_girl);
        smoke = (GifMovieView) page.findViewById(R.id.gif_p04_smoke);
        p04_bg_up = (AbsoluteLayout) page.findViewById(R.id.p04_bg_up);

        fire.setMovieAsset(ctx.getString(R.string.p04_fire));
        girl.setMovieAsset(ctx.getString(R.string.p04_girl));
        smoke.setMovieAsset(ctx.getString(R.string.p04_smoke));

        //dynamic
        params = (AbsoluteLayout.LayoutParams) p04_bg_up.getLayoutParams();
        params.width = (int) getWinWidth();
        params.height = (int) getWinHeight();
        p04_bg_up.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p04);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(3));

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
        fire.Clear();
        girl.Clear();
        smoke.Clear();
    }
}
