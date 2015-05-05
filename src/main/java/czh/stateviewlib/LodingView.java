package czh.stateviewlib;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Administrator on 2015/5/5.
 */
public class LodingView extends ImageView{
    public LodingView(Context context) {
        this(context,null);
    }

    public LodingView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LodingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        AnimationDrawable an=(AnimationDrawable)getBackground();
        an.start();
    }


}
