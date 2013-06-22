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
public class Page11 extends PageView {

    private GifMovieView butterfly;
    private GifMovieView girl;
    private GifMovieView sky_cloud;

    public Page11(Context context) {
        super(context, R.layout.page11);

        butterfly = (GifMovieView) page.findViewById(R.id.gif_p11_butterfly);
        sky_cloud = (GifMovieView) page.findViewById(R.id.gif_p11_sky_cloud);
        girl = (GifMovieView) page.findViewById(R.id.gif_p11_girl);

        butterfly.setMovieAsset(ctx.getString(R.string.p11_butterfly));
        girl.setMovieAsset(ctx.getString(R.string.p11_girl));
        sky_cloud.setMovieAsset(ctx.getString(R.string.p11_sky_cloud));

        params = (AbsoluteLayout.LayoutParams) butterfly.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p11_butterfly_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p11_butterfly_y));
        butterfly.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) girl.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p11_girl_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p11_girl_y));
        girl.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) sky_cloud.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p11_sky_cloud_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p11_sky_cloud_y));
        sky_cloud.setLayoutParams(params);

        layout = page.findViewById(R.id.ll_p11_bg);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(10));
    }
}
