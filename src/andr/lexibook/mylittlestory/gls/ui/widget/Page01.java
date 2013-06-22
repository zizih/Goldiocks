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
public class Page01 extends PageView {

    private GifMovieView door;
    private GifMovieView flower;
    private GifMovieView girl;
    private GifMovieView tree;

    public Page01(Context context) {
        super(context, R.layout.page01);
        door = (GifMovieView) page.findViewById(R.id.gif_p01_door);
        flower = (GifMovieView) page.findViewById(R.id.gif_p01_flower);
        girl = (GifMovieView) page.findViewById(R.id.gif_p01_girl);
        tree = (GifMovieView) page.findViewById(R.id.gif_p01_tree);

        door.setMovieAsset(context.getString(R.string.p01_door));
        flower.setMovieAsset(context.getString(R.string.p01_flower));
        girl.setMovieAsset(context.getString(R.string.p01_girl));
        tree.setMovieAsset(context.getString(R.string.p01_tree));

        params = ((AbsoluteLayout.LayoutParams) door.getLayoutParams());
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p01_door_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p01_door_y));
        door.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) flower.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p01_flower_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p01_flower_y));
        flower.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) girl.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p01_girl_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p01_girl_y));
        girl.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) tree.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p01_tree_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p01_tree_y));
        tree.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p01);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(0));
    }

}
