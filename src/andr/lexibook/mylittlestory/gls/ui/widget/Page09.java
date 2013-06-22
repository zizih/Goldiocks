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
public class Page09 extends PageView {

    private GifMovieView fa;
    private GifMovieView girl;
    private GifMovieView ma;

    public Page09(Context context) {
        super(context, R.layout.page09);

        fa = (GifMovieView) page.findViewById(R.id.gif_p09_fa);
        girl = (GifMovieView) page.findViewById(R.id.gif_p09_girl);
        ma = (GifMovieView) page.findViewById(R.id.gif_p09_ma);

        fa.setMovieAsset(ctx.getString(R.string.p09_fa));
        girl.setMovieAsset(ctx.getString(R.string.p09_girl));
        ma.setMovieAsset(ctx.getString(R.string.p09_ma));

        params = (AbsoluteLayout.LayoutParams) fa.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p09_fa_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p09_fa_y));
        fa.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) girl.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p09_girl_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p09_girl_y));
        girl.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) ma.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p09_ma_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p09_ma_y));
        ma.setLayoutParams(params);

        layout = page.findViewById(R.id.layout_p09);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(8));
    }
}
