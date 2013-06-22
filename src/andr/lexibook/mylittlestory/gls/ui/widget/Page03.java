package andr.lexibook.mylittlestory.gls.ui.widget;

import andr.lexibook.mylittlestory.gls.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.gls.ui.ViewIml.PageView;
import andr.lexibook.mylittlestory.gls.ui.R;
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

        params = (AbsoluteLayout.LayoutParams) girl.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p03_girl_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p03_girl_y));
        girl.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) sky.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p03_sky_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p03_sky_y));
        sky.setLayoutParams(params);

        layout = page.findViewById(R.id.ll_p03_bg);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(2));
    }
}
