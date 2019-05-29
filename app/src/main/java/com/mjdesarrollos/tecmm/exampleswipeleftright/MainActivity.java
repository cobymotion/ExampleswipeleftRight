package com.mjdesarrollos.tecmm.exampleswipeleftright;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity
    implements GestureDetector.OnGestureListener {

    private GestureDetectorCompat gestor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestor = new GestureDetectorCompat(this,this);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (this.gestor.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onFling(MotionEvent downEvent, MotionEvent moveEvent, float vX, float veloc) {
        Log.e("SWIPE","Se activo evento");
        boolean result = false;
        float diffX = moveEvent.getX() - downEvent.getX();
        float diffY = moveEvent.getY() - downEvent.getY();
        if(Math.abs(diffX)>Math.abs(diffY))
        {
            /// izquierda o derecha
            if(Math.abs(diffX)>100 && Math.abs(vX)>100){
                if(diffX>0)
                    Log.e("SWIPE", "Derecha");
                else
                    Log.e("SWIPE","Izquierda");

            }
        }
        return false;
    }
}
