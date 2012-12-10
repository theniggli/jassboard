package ch.zhaw.jassboard.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import ch.zhaw.jassboard.activity.JasstafelActivity;
import ch.zhaw.jassboard.activity.SchieberActivity;

import java.util.ArrayList;

import static android.widget.Toast.*;

/**
 * Draw Board and add ontouch-functions
 *
 * @author <a href=mailto:stjepton@students.zhaw.ch>toni</a>
 * @since 12/1/12 8:50 AM
 */

public class SchieberView extends View {
    private static final float scoreTextSizeDp = 16.0F;
    SchieberActivity _activity;
    Bitmap _bitmap;
    Canvas _canvas;
    private int _height;
    Paint _paint;
    private int _width;
    float[] lines = new float[28];
    int lines_num = 0;
    ArrayList<RectF> rectangles = new ArrayList();
    int rectangles_num = 0;
    ArrayList<Float> rectangles_rotation = new ArrayList();
    private int scoreTextSize = 18;
    RectF zone_b_100;
    RectF zone_b_20;
    RectF zone_b_50;
    RectF zone_b_custom;
    RectF zone_b_total;
    RectF zone_t_100;
    RectF zone_t_20;
    RectF zone_t_50;
    RectF zone_t_custom;
    RectF zone_t_total;
    private Context paramContext;

    public SchieberView(Context paramContext) {
        super(paramContext);
        this._activity = ((SchieberActivity) paramContext);
        this.paramContext = paramContext;
        this._paint = new Paint();
        this._paint.setColor(-1);
        this._paint.setStyle(Style.STROKE);
        this.scoreTextSize = (int) (0.5F + 16.0F * getResources().getDisplayMetrics().density);
    }

    private void calculateLinePlacements() {
        this.lines_num = 0;
        this.lines[(0 + 4 * this.lines_num)] = 0.0F;
        this.lines[(1 + 4 * this.lines_num)] = this._height / 2;
        this.lines[(2 + 4 * this.lines_num)] = this._width;
        this.lines[(3 + 4 * this.lines_num)] = this._height / 2;
        this.lines_num = (1 + this.lines_num);
        this.lines[(0 + 4 * this.lines_num)] = this._width / 12;
        this.lines[(1 + 4 * this.lines_num)] = this._height / 20;
        this.lines[(2 + 4 * this.lines_num)] = this._width - this._width / 12;
        this.lines[(3 + 4 * this.lines_num)] = this._height / 20;
        this.lines_num = (1 + this.lines_num);
        this.lines[(0 + 4 * this.lines_num)] = this._width - this._width / 12;
        this.lines[(1 + 4 * this.lines_num)] = this._height / 20;
        this.lines[(2 + 4 * this.lines_num)] = this._width / 12;
        this.lines[(3 + 4 * this.lines_num)] = this._height / 2 - this._height / 20;
        this.lines_num = (1 + this.lines_num);
        this.lines[(0 + 4 * this.lines_num)] = this._width / 12;
        this.lines[(1 + 4 * this.lines_num)] = this._height / 2 - this._height / 20;
        this.lines[(2 + 4 * this.lines_num)] = this._width - this._width / 12;
        this.lines[(3 + 4 * this.lines_num)] = this._height / 2 - this._height / 20;
        this.lines_num = (1 + this.lines_num);
        this.lines[(0 + 4 * this.lines_num)] = this._width / 12;
        this.lines[(1 + 4 * this.lines_num)] = this._height / 2 + this._height / 20;
        this.lines[(2 + 4 * this.lines_num)] = this._width - this._width / 12;
        this.lines[(3 + 4 * this.lines_num)] = this._height / 2 + this._height / 20;
        this.lines_num = (1 + this.lines_num);
        this.lines[(0 + 4 * this.lines_num)] = this._width - this._width / 12;
        this.lines[(1 + 4 * this.lines_num)] = this._height / 2 + this._height / 20;
        this.lines[(2 + 4 * this.lines_num)] = this._width / 12;
        this.lines[(3 + 4 * this.lines_num)] = this._height - this._height / 20;
        this.lines_num = (1 + this.lines_num);
        this.lines[(0 + 4 * this.lines_num)] = this._width / 12;
        this.lines[(1 + 4 * this.lines_num)] = this._height - this._height / 20;
        this.lines[(2 + 4 * this.lines_num)] = this._width - this._width / 12;
        this.lines[(3 + 4 * this.lines_num)] = this._height - this._height / 20;
        this.lines_num = (1 + this.lines_num);
    }

    private void calculatePoints() {
//        this.rectangles_num = 0;
//        this.rectangles.clear();
//        this.rectangles_rotation.clear();
//        // TODO: what are the floats?
//        float f1 = 6 + this._width / 12;
//        float f2 = -15 + this._height / 20;
//        int i = 1;
//        // TODO: Count Points of Team T by 20
////        if (i > this._activity.team_t.get_20()) ;
//
//        // TODO: wtf is that?
//        if (i > 5) {
////        label59:
////        label101:
//        }
//        float f7 = 0;
////        label157:
////        label211:
//        float f8 = 0;
//        int i1 = 1;
////        label302:
////        label971:
////            break label302;
//            double d1 = 3 * this._width / 4;
//            double d2 = 13 * this._height / 100;
//            int j = 100;
//            // TODO: what are the floats?
//            float f3 = 0;
//            float f4 = 0;
//            int k = 1;
//            float f5 = 0;
//            float f6 = 0;
//            int m = 1;
//            double d3 = 0;
//            double d4 = 0;
//            int n = 1;
//            if (j > 1) {
//                f3 = -6 + (this._width - this._width / 12);
//                f4 = 15 + (this._height / 2 - this._height / 20);
//                k = 1;
//                // TODO: Count Points of Team T by 20
//                // if (k <= this._activity.team_t.get_100())
//                if (k <= 2) {
////                    break label645;
//                }
//                    f5 = -6 + (this._width - this._width / 12);
//                f6 = 15 + (this._height - this._height / 20);
//                m = 1;
//                // TODO: Count Points of Team T by 20
////                if (m <= this._activity.team_b.get_20())
//                if (m <= 3) {
////                    break label808;
//                }
//                    d3 = this._width / 4;
//                d4 = 87 * this._height / 100;
//                n = 5;
//                // TODO: Count Points of Team T by 20
////                if (n <= this._activity.team_b.get_50())
//                if (n <= 4) {
////                    break label971;
//                }
//            }
//            while (n < getMax50()) {
//                f7 = 6 + this._width / 12;
//                f8 = -15 + (this._height / 2 + this._height / 20);
//                i1 = 1;
//                // TODO: Count Points of Team T by 100
////                if (i1 <= this._activity.team_b.get_100())
//                if (i1 <= 3) {
////                    break label1164;
////                    return;
//                }
//                if (i > getMax20()){
////                    break label59;}
//                    if (i % 5 == 0) {
//                        this.rectangles.add(this.rectangles_num, new RectF(f1 - 17.0F, f2 - 7.0F, 4.0F + f1 - 17.0F, 37.0F + f2));
//                        this.rectangles_rotation.add(this.rectangles_num, 55.0F);
//                        this.rectangles_num = (1 + this.rectangles_num);
//                    }
//                    // TODO: fix infinite loop
////                for (f1 += 14.0F; ; f1 += 7.0F) {
////                    i++;
//////                    break;
////                    this.rectangles.add(this.rectangles_num, new RectF(f1, f2, 4.0F + f1, 30.0F + f2));
////                    this.rectangles_rotation.add(this.rectangles_num, Float.valueOf(0.0F));
////                    this.rectangles_num = (1 + this.rectangles_num);
////                }
////                if (j > getMax50()){
//////                    break label101;
////                }
//                if (j % 2 == 0) {
//                    this.rectangles.add(this.rectangles_num, new RectF((float) d1 - 2.0F, (float) d2 - 15.0F, 2.0F + (float) d1, 15.0F + (float) d2));
//                    this.rectangles_rotation.add(this.rectangles_num, Float.valueOf(-70.0F));
//                    this.rectangles_num = (1 + this.rectangles_num);
//                    d1 -= 20.0D;
//                    d2 += 20.0D * (485.0D * this._height) / (1000.0D * this._width);
//                }
//                while (true) {
//                    j++;
//                    this.rectangles.add(this.rectangles_num, new RectF((float) d1 - 2.0F, (float) d2 - 15.0F, 2.0F + (float) d1, 15.0F + (float) d2));
//                    this.rectangles_rotation.add(this.rectangles_num, Float.valueOf(-10.0F));
//                    this.rectangles_num = (1 + this.rectangles_num);
//                    break; //TODO: break not here orignially
//                }
////                if (k > getMax100())
//////                    break label157;
//                    if (k % 5 == 0) {
//                        this.rectangles.add(this.rectangles_num, new RectF(17.0F + f3, f4 - 37.0F, 4.0F + (17.0F + f3), 7.0F + f4));
//                        this.rectangles_rotation.add(this.rectangles_num, Float.valueOf(55.0F));
//                        this.rectangles_num = (1 + this.rectangles_num);
//                    }
////                for (f3 -= 14.0F; ; f3 -= 7.0F) {
////                    k++;
////                    break;
////                    this.rectangles.add(this.rectangles_num, new RectF(f3 - 4.0F, f4 - 30.0F, f3, f4));
////                    this.rectangles_rotation.add(this.rectangles_num, Float.valueOf(0.0F));
////                    this.rectangles_num = (1 + this.rectangles_num);
////                }
////                if (m > getMax20())
//////                    break label211;
//                    if (m % 5 == 0) {
//                        this.rectangles.add(this.rectangles_num, new RectF(14.0F + f5, f6 - 37.0F, 4.0F + (14.0F + f5), 7.0F + f6));
//                        this.rectangles_rotation.add(this.rectangles_num, Float.valueOf(55.0F));
//                        this.rectangles_num = (1 + this.rectangles_num);
//                    }
////                for (f5 -= 14.0F; ; f5 -= 7.0F) {
////                    m++;
////                    break;
////                    this.rectangles.add(this.rectangles_num, new RectF(f5 - 4.0F, f6 - 30.0F, f5, f6));
////                    this.rectangles_rotation.add(this.rectangles_num, Float.valueOf(0.0F));
////                    this.rectangles_num = (1 + this.rectangles_num);
////                }
////            }
//            if (n % 2 == 0) {
//                this.rectangles.add(this.rectangles_num, new RectF((float) d3 - 2.0F, (float) d4 - 15.0F, 2.0F + (float) d3, 15.0F + (float) d4));
//                this.rectangles_rotation.add(this.rectangles_num, Float.valueOf(-10.0F));
//                this.rectangles_num = (1 + this.rectangles_num);
//                d3 += 20.0D;
//                d4 -= 20.0D * (485.0D * this._height) / (1000.0D * this._width);
//            }
//            while (true) {
//                n++;
//                this.rectangles.add(this.rectangles_num, new RectF((float) d3 - 2.0F, (float) d4 - 15.0F, 2.0F + (float) d3, 15.0F + (float) d4));
//                this.rectangles_rotation.add(this.rectangles_num, Float.valueOf(-70.0F));
//                this.rectangles_num = (1 + this.rectangles_num);
//                break;//TODO break not originally here
//            }
//        }
////        while (i1 > getMax100());
////        label645:
////        label808:
//        if (i1 % 5 == 0) {
//            this.rectangles.add(this.rectangles_num, new RectF(f7 - 14.0F, f8 - 7.0F, 4.0F + f7 - 14.0F, 37.0F + f8));
//            this.rectangles_rotation.add(this.rectangles_num, Float.valueOf(55.0F));
//            this.rectangles_num = (1 + this.rectangles_num);
//        }
////        label1164:
////        for (f7 += 14.0F; ; f7 += 7.0F) {
////            i1++;
////            break;
////            this.rectangles.add(this.rectangles_num, new RectF(f7, f8, 4.0F + f7, 30.0F + f8));
////            this.rectangles_rotation.add(this.rectangles_num, Float.valueOf(0.0F));
////            this.rectangles_num = (1 + this.rectangles_num);
////        }
//        }
}


    private void calculateZonePlacements() {
        this.zone_t_100 = new RectF(this._width / 2, 2 * this._height / 6, this._width, 3 * this._height / 6);
        this.zone_t_50 = new RectF(this._width / 3, 1 * this._height / 6, 2 * this._width / 3, 2 * this._height / 6);
        this.zone_t_20 = new RectF(0.0F, 0.0F, this._width / 2, this._height / 6);
        this.zone_t_custom = new RectF(0.0F, 1 * this._height / 6, 1 * this._width / 3, 2 * this._height / 6);
        this.zone_t_total = new RectF(2 * this._width / 3, 1 * this._height / 6, this._width, 2 * this._height / 6);
        this.zone_b_100 = new RectF(0.0F, 3 * this._height / 6, this._width / 2, 4 * this._height / 6);
        this.zone_b_50 = new RectF(this._width / 3, 4 * this._height / 6, 2 * this._width / 3, 5 * this._height / 6);
        this.zone_b_20 = new RectF(this._width / 2, 5 * this._height / 6, this._width, this._height);
        this.zone_b_custom = new RectF(2 * this._width / 3, 4 * this._height / 6, this._width, 5 * this._height / 6);
        this.zone_b_total = new RectF(0.0F, 4 * this._height / 6, this._width / 3, 5 * this._height / 6);
    }

    private void drawBoard() {
        this._canvas.drawLines(this.lines, 0, 4 * this.lines_num, this._paint);
        this._paint.setStyle(Style.FILL);
//        int i = 0;
//        if (i >= this.rectangles_num) {
//            invalidate();
//            return;
//        }
        //TODO: this code is unreachable and does not work, what is it's function? ;)
//        if (this.rectangles_rotation.get(i) == 0.0F) {
//            this._canvas.drawRoundRect(this.rectangles.get(i), 2.0F, 2.0F, this._paint);
//            while (true) {
//                i++;
//                this._canvas.save();
//                this._canvas.rotate(this.rectangles_rotation.get(i), (this.rectangles.get(i)).centerX(), this.rectangles.get(i).centerY());
//                this._canvas.drawRoundRect(this.rectangles.get(i), 2.0F, 2.0F, this._paint);
//                this._canvas.restore();
//                break;
//            }
//        }
    }
    //277457
    public void onActivityResult(int reqCode, int resCode, Intent data){
        Toast.makeText(getContext(),data.getIntExtra("Result1",0) ,Toast.LENGTH_LONG).show();
        resultA = data.getIntExtra("Result1",10);
        draw();
    }

    public void draw() {
       // this._activity.team_t.realignScore(getMax20(), getMax50());
       // this._activity.team_b.realignScore(getMax20(), getMax50());
        this._bitmap.eraseColor(-16777216);
        this._paint.setAntiAlias(true);
        this._paint.setTextSize(this.scoreTextSize);
        this._canvas.save();
        this._canvas.rotate(180.0F, this._width / 2, this._height / 2 - this.scoreTextSize);
        // draw current score of team a
        // TODO: Dynamically get Points!!!
//        this._canvas.drawText(Integer.toString(50), this._width / 2, this._height / 2 - this.scoreTextSize, this._paint);
        this._canvas.restore();
        // draw current score of team b
        // TODO: Dynamically get Points!!!
//        this._canvas.drawText(Integer.toString(50), this._width / 2, this._height / 2 + this.scoreTextSize, this._paint);
        this._paint.setTextSize(this.scoreTextSize);
        this._canvas.save();
        this._canvas.rotate(180.0F, this._width / 4, 2 * this._height / 10);
        // TODO: Dynamically get Points!!!
        this._canvas.drawText(Integer.toString(50), this._width / 4, 2 * this._height / 10, this._paint);
        this._canvas.restore();
        // TODO: Dynamically get Points!!!
        // draw points of bottom team
        this._canvas.drawText(Integer.toString(50), 3 * this._width / 4, 8 * this._height / 10, this._paint);
        calculateLinePlacements();
        calculateZonePlacements();
        calculatePoints();
        drawBoard();
    }

    public int getMax100() {
        return 5 * (int) ((10.0D * this._width / 12.0D - 12.0D) / 42.0D);
    }

    public int getMax20() {
        return 5 * (int) ((10.0D * this._width / 12.0D - 12.0D) / 42.0D);
    }

    public int getMax50() {
        return 2 * (int) (this._width / 2.0D / 20.0D);
    }

    protected void onDraw(Canvas paramCanvas) {
        paramCanvas.drawBitmap(this._bitmap, 0.0F, 0.0F, this._paint);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        this._height = MeasureSpec.getSize(paramInt2);
        this._width = MeasureSpec.getSize(paramInt1);
        this._bitmap = Bitmap.createBitmap(this._width, this._height, Config.ARGB_8888);
        this._canvas = new Canvas(this._bitmap);
        setMeasuredDimension(this._width, this._height);
        draw();
    }

    /*
    Handle touch events and show dialogs
     */
    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
//        if (paramMotionEvent.getAction() == 0) {
//            if (this.zone_t_100.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
//                this._activity.team_t.add_score(100);
//                this._activity.team_b.add_score(0);
//            }
//            if (this.zone_t_50.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
//                this._activity.team_t.add_score(50);
//                this._activity.team_b.add_score(0);
//            }
//            if (this.zone_t_20.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
//                this._activity.team_t.add_score(20);
//                this._activity.team_b.add_score(0);
//            }
            // Team on the top
            if (this.zone_t_custom.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
                //paramContext.startActivity(new Intent(paramContext, ScoreDialog.class));
                //277457
                //((Activity)getContext()).startActivityForResult(new Intent(paramContext, ScoreDialog.class), 0);
                ((Activity)paramContext).startActivityForResult(new Intent(paramContext, ScoreDialog.class), 1);
                int abc = 1;

            }
            // Team on the bottom
            if (this.zone_b_custom.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
            {
                //paramContext.startActivity(new Intent(paramContext, ScoreDialog.class));
                //277457
                //((Activity)getContext()).startActivityForResult(new Intent(paramContext, ScoreDialog.class), 0);
                ((Activity)paramContext).startActivityForResult(new Intent(paramContext, ScoreDialog.class), 1);
                int abc = 1;
            }

//            if (this.zone_b_100.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
//                this._activity.team_b.add_score(100);
//                this._activity.team_t.add_score(0);
//            }
//            if (this.zone_b_50.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
//                this._activity.team_b.add_score(50);
//                this._activity.team_t.add_score(0);
//            }
//            if (this.zone_b_20.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
//                this._activity.team_b.add_score(20);
//                this._activity.team_t.add_score(0);
//            }
//            if (this.zone_b_custom.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
//                this._activity.showCustomDialog(1);
//            if (this.zone_b_total.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
//                this._activity.showCustomDialog(3);
//        }
        draw();
        return true;
    }
}