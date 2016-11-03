package xingstarx.com.dragframelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import xingstarx.com.dragframelayout.view.DragFrameLayout;

public class MainActivity extends AppCompatActivity {

    private DragFrameLayout mRootView;
    private View mPlayerView;
    private View mMsgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRootView = (DragFrameLayout) findViewById(R.id.root_view);
        mPlayerView = findViewById(R.id.player);
        mMsgView = findViewById(R.id.msg_container);


    }
}
