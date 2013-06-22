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
public class Page04 extends PageView {

    private GifMovieView fire;
    private GifMovieView girl;
    private GifMovieView smoke;

    public Page04(Context context) {
        super(context, R.layout.page04);

        fire = (GifMovieView) page.findViewById(R.id.gif_p04_fire);
        girl = (GifMovieView) page.findViewById(R.id.gif_p04_girl);
        smoke = (GifMovieView) page.findViewById(R.id.gif_p04_smoke);

        fire.setMovieAsset(ctx.getString(R.string.p04_fire));
        girl.setMovieAsset(ctx.getString(R.string.p04_girl));
        smoke.setMovieAsset(ctx.getString(R.string.p04_smoke));

        params = (AbsoluteLayout.LayoutParams) fire.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p04_fire_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p04_fire_y));
        fire.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) girl.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p04_girl_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p04_girl_y));
        girl.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) smoke.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p04_smoke_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p04_smoke_y));
        smoke.setLayoutParams(params);

        layout = page.findViewById(R.id.layout_p04);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(3));
    }
}
