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

    public Page08(Context context) {
        super(context, R.layout.page08);

        bb = (GifMovieView) page.findViewById(R.id.gif_p08_bb);
        bowl = (GifMovieView) page.findViewById(R.id.gif_p08_bowl);
        fa = (GifMovieView) page.findViewById(R.id.gif_p08_fa);
        fire = (GifMovieView) page.findViewById(R.id.gif_p08_fire);
        ma = (GifMovieView) page.findViewById(R.id.gif_p08_ma);
        smoke = (GifMovieView) page.findViewById(R.id.gif_p08_smoke);

        bb.setMovieAsset(ctx.getString(R.string.p08_bb));
        bowl.setMovieAsset(ctx.getString(R.string.p08_bowl));
        fa.setMovieAsset(ctx.getString(R.string.p08_fa));
        fire.setMovieAsset(ctx.getString(R.string.p08_fire));
        ma.setMovieAsset(ctx.getString(R.string.p08_ma));
        smoke.setMovieAsset(ctx.getString(R.string.p08_smoke));

        params = (AbsoluteLayout.LayoutParams) bb.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p08_bb_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p08_bb_y));
        bb.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) bowl.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p08_bowl_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p08_bowl_y));

        params = (AbsoluteLayout.LayoutParams) fa.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p08_fa_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p08_fa_y));
        fa.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) fire.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p08_fire_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p08_fire_y));
        fire.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) ma.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p08_ma_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p08_ma_y));
        ma.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) smoke.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p08_smoke_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p08_smoke_y));
        smoke.setLayoutParams(params);

        layout = page.findViewById(R.id.layout_p08);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(7));
    }
}
