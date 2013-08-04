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

        layout = (AbsoluteLayout) page.findViewById(R.id.ll_p11_bg);
        //dynamic
        params = (AbsoluteLayout.LayoutParams) layout.getLayoutParams();
        params.width = (int) getWinWidth();
        params.height = (int) getWinHeight();
        layout.setLayoutParams(params);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(10));

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
        butterfly.Clear();
        sky_cloud.Clear();
        girl.Clear();
    }
}
