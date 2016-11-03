package xingstarx.com.dragframelayout.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by xiongxingxing on 16/11/3.
 */

public class DragFrameLayout extends FrameLayout {
    public static final String TAG = "DragFrameLayout";
    private View mContentView;
    private View mHeaderView;
    private int mLastMotionY;
    private int mContentTopMargin;


    public DragFrameLayout(Context context) {
        super(context);
    }

    public DragFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DragFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DragFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        mHeaderView = getChildAt(0);
        mContentView = getChildAt(1);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled() || mContentView == null || mHeaderView == null) {
            return super.onTouchEvent(event);
        }
        final int y = (int) event.getRawY();
        LayoutParams lp = (LayoutParams) mContentView.getLayoutParams();
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mContentTopMargin = lp.topMargin;
                mLastMotionY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                if (y - mLastMotionY < 0) {
                    lp.topMargin = mContentTopMargin + y - mLastMotionY;
                    mContentView.setLayoutParams(lp);
                }
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                lp.topMargin = mContentTopMargin;
                mContentView.setLayoutParams(lp);
                break;

        }
        return true;
    }
}
