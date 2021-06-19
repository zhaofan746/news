package com.example.headlinenews.fragment.home.history.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class CustomRelativeLayout extends RelativeLayout {
    private int rawX,rawY;
    private IMoveListener moveListener;

    public void registerMoveListener(IMoveListener moveListener) {
        this.moveListener = moveListener;
    }

    public CustomRelativeLayout(Context context) {
        super(context);
    }

    public CustomRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(ev.getAction() == MotionEvent.ACTION_DOWN){
            rawX = (int) ev.getRawX();
            rawY = (int) ev.getRawY();

        } else if(ev.getAction() == MotionEvent.ACTION_MOVE){
            if(Math.abs(ev.getRawX()-rawX) > 10 || Math.abs(ev.getRawY() - rawY) >10){
                rawX = (int) ev.getRawX();
                rawY = (int) ev.getRawY();
                return true;
            }
        } else if(ev.getAction() == MotionEvent.ACTION_UP){

        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(ev.getAction() == MotionEvent.ACTION_DOWN){

        } else if(ev.getAction() == MotionEvent.ACTION_MOVE){
            if (moveListener != null) {
                moveListener.onMove(rawX,rawY,(int)ev.getRawX(),(int)ev.getRawY());
                rawX = (int) ev.getRawX();
                rawY = (int) ev.getRawY();
            }
        } else if(ev.getAction() == MotionEvent.ACTION_UP){

        }
        return super.onTouchEvent(ev);
    }

    public interface IMoveListener {
        void onMove(int lastX, int lastY, int newX,int newY);
    }
}
