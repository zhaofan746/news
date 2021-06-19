package com.example.headlinenews.fragment.home.history.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.headlinenews.R;


public class CustomTranslateLayout extends FrameLayout {
    private Context context;
    private CustomRelativeLayout rootView;
    private CustomTranslateLayout instance;
    private ImageView itemPlay;
    private ImageView itemAdd;
    private ImageView itemNew;
    private int width = 250;//以像素为单位，布局里面的单位是dp

    public CustomTranslateLayout(@NonNull Context context) {
        this(context,null);
    }

    public CustomTranslateLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
        instance = this;
    }

    public CustomTranslateLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void init(Context context, AttributeSet attrs) {

        LayoutInflater.from(context).inflate(R.layout.view_translate, this);
        rootView = findViewById(R.id.itemRootView);
        ImageView itemHead = findViewById(R.id.itemHead);
        //点击头像变长
        itemHead.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startChangeToLarge();
                Toast.makeText(context, "按钮head", Toast.LENGTH_SHORT).show();
            }
        });
        itemPlay = findViewById(R.id.itemPlay);
        itemAdd = findViewById(R.id.itemAdd);
        itemNew = findViewById(R.id.itemNew);
        itemPlay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "按钮paly", Toast.LENGTH_SHORT).show();
            }
        });

        itemAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessageDelayed(2,10);
            }
        });

        rootView.registerMoveListener(new CustomRelativeLayout.IMoveListener() {
            @Override
            public void onMove(int lastX, int lastY, int newX, int newY) {
                int x = newX - lastX;
                int y = newY - lastY;

                CustomTranslateLayout.this.layout(CustomTranslateLayout.this.getLeft()+x,CustomTranslateLayout.this.getTop()+y,
                        CustomTranslateLayout.this.getRight()+x,CustomTranslateLayout.this.getBottom()+y);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(CustomTranslateLayout.this.width,CustomTranslateLayout.this.getHeight());
                layoutParams.leftMargin = CustomTranslateLayout.this.getLeft();
                layoutParams.topMargin = CustomTranslateLayout.this.getTop();
                layoutParams.rightMargin = CustomTranslateLayout.this.getRight();
                layoutParams.bottomMargin = CustomTranslateLayout.this.getBottom();
                layoutParams.setMargins(CustomTranslateLayout.this.getLeft(),CustomTranslateLayout.this.getTop(),0,0);
                CustomTranslateLayout.this.setLayoutParams(layoutParams);//通过该方法，存储到View里
            }
        });

    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(width >= 900){
                    viewShowAndHide(VISIBLE);
                    return;
                }
                width += 10;
                requestLayout();
                handler.sendEmptyMessageDelayed(1,10);

            } else if(msg.what == 2){
                viewShowAndHide(GONE);
                if(width <= 250){
                    return;
                }
                width -= 10;
                requestLayout();
                handler.sendEmptyMessageDelayed(2,10);
            }
        }
    };



    private void startChangeToLarge(){
        if (handler.hasMessages(1) || width >= 900) {
            return;
        }
        viewShowAndHide(GONE);
        handler.removeCallbacksAndMessages(null);
        width = 250;
        requestLayout();
        handler.sendEmptyMessageDelayed(1,10);
    }
    private void viewShowAndHide(int visible) {
        itemPlay.setVisibility(visible);
        itemAdd.setVisibility(visible);
        itemNew.setVisibility(visible);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(width,250);
    }
    //设置在
    public void resetWidth(MotionEvent event){
        //判断时候是否点到控件上
        if(isTouchCurrentView(event)){
            return;
        }
        if(handler.hasMessages(2) || width <= 250){
            Log.d("zyb", "resetWidth: 方法");
            return;
        }
        handler.removeCallbacksAndMessages(null);//把之前的消息全部停止，全力做好控件的收缩操作
        handler.sendEmptyMessageDelayed(2, 10);//通过handler自定义收缩动画，完成收缩操作
    }
    //判断时候在这个控件
    private boolean isTouchCurrentView(MotionEvent event) {
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        int[] ints = new int[2];
        getLocationOnScreen(ints);
        int left = ints[0];
        int top = ints[1];
        int right = left + getMeasuredWidth();
        int bottom = top + getMeasuredHeight();
        if(rawX >= left && rawX <= right && rawY>= top && rawY<=bottom){
            return true;
        }
        return false;
    }
}
