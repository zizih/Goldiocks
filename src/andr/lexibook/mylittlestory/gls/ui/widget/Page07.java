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
public class Page07 extends PageView {

    private GifMovieView window;
    private GifMovieView girl;

    public Page07(Context context) {
        super(context, R.layout.page07);
        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p07);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(6));

        //get view
        window = (GifMovieView) page.findViewById(R.id.gif_p07_window);
        girl = (GifMovieView) page.findViewById(R.id.gif_p07_girl);
        window.setMovieAsset(ctx.getString(R.string.p07_window));
        girl.setMovieAsset(ctx.getString(R.string.p07_girl));

        //dynamic
        params = (AbsoluteLayout.LayoutParams) window.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p07_window_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p07_window_y));
        window.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) girl.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p07_girl_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p07_girl_y));
        girl.setLayoutParams(params);

    }

    public GifMovieView getWindow() {
        if (window.getParent() != null)
            ((AbsoluteLayout) window.getParent()).removeView(window);
        window.setPaused(4000);
        window.invalidate();
        return window;
    }

}