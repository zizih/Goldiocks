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
public class Page08 extends PageView {

    private GifMovieView bb;
    private GifMovieView bowl;
    private GifMovieView fa;
    private GifMovieView fire;
    private GifMovieView ma;
    private GifMovieView smoke;

    private AbsoluteLayout p08_bg_up;

    public Page08(Context context) {
        super(context, R.layout.page08);

        bb = (GifMovieView) page.findViewById(R.id.gif_p08_bb);
        bowl = (GifMovieView) page.findViewById(R.id.gif_p08_bowl);
        fa = (GifMovieView) page.findViewById(R.id.gif_p08_fa);
        fire = (GifMovieView) page.findViewById(R.id.gif_p08_fire);
        ma = (GifMovieView) page.findViewById(R.id.gif_p08_ma);
        smoke = (GifMovieView) page.findViewById(R.id.gif_p08_smoke);
        p08_bg_up = (AbsoluteLayout) page.findViewById(R.id.p08_bg_up);

        bb.setMovieAsset(ctx.getString(R.string.p08_bb));
        bowl.setMovieAsset(ctx.getString(R.string.p08_bowl));
        fa.setMovieAsset(ctx.getString(R.string.p08_fa));
        fire.setMovieAsset(ctx.getString(R.string.p08_fire));
        ma.setMovieAsset(ctx.getString(R.string.p08_ma));
        smoke.setMovieAsset(ctx.getString(R.string.p08_smoke));

        //dynamic
        params = (AbsoluteLayout.LayoutParams) p08_bg_up.getLayoutParams();
        params.width = (int) getWinWidth();
        params.height = (int) getWinHeight();
        p08_bg_up.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p08);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(7));

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
        bb.Clear();
        bowl.Clear();
        fire.Clear();
        fa.Clear();
        ma.Clear();
        smoke.Clear();
    }
}
