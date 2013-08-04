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
public class Page06 extends PageView {


    private GifMovieView cabinet;
    private GifMovieView girl;

    public Page06(Context context) {
        super(context, R.layout.page06);

        cabinet = (GifMovieView) page.findViewById(R.id.gif_p06_cabinet);
        girl = (GifMovieView) page.findViewById(R.id.gif_p06_girl);

        cabinet.setMovieAsset(ctx.getString(R.string.p06_cabinet));
        girl.setMovieAsset(ctx.getString(R.string.p06_girl));

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p06);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(5));

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
        cabinet.Clear();
        girl.Clear();
    }
}
