package ch.zhaw.jassboard.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.*;
import android.graphics.Bitmap.Config;
import android.graphics.Paint.Style;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import ch.zhaw.jassboard.activity.SchieberActivity;
import ch.zhaw.jassboard.persist.GlobalContext;

import java.util.ArrayList;

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

    float[] points = new float[1000];
    int points_num = 0;

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
    int resultA = 0;
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

    private void drawBoard() {
        this._canvas.drawLines(this.lines, 0, 4 * this.lines_num, this._paint);
        this._paint.setStyle(Style.FILL);

        float width = this._width;
        float height = this._height;

        this._paint.setColor(Color.GREEN);
        this._canvas.drawLine(0, (height / 2), width, (height / 2), this._paint);
        this._paint.setColor(Color.YELLOW);

        this._canvas.drawLines(this.points, 0, 4 * this.points_num, this._paint);

        this._paint.setColor(Color.WHITE);

    }

    public void calculatePoints() {
        float width = this._width;
        float height = this._height;
        this.points_num = 0;

//        startX
//        startY
//        stopX
//        stopY

        //team top
        //20
//          for (int j = 1; j == this._activity.team_b.get_20(); j++) {
        for (int j = 1; j < 10; j++) {
            if (j % 5 == 0) {
                //schief
                points[(0 + 4 * this.points_num)] = width - 2 * (width / 12) - j * width / 40 + 5 * width / 40;
                points[(1 + 4 * this.points_num)] = height / 40;
                points[(2 + 4 * this.points_num)] = width - 2 * (width / 12) - j * width / 40;
                points[(3 + 4 * this.points_num)] = height / 20 + height / 40;
                this.points_num++;
            } else {
                //"normal"
                points[(0 + 4 * this.points_num)] = width - 2 * (width / 12) - j * width / 40;
                points[(1 + 4 * this.points_num)] = height / 40;
                points[(2 + 4 * this.points_num)] = width - 2 * (width / 12) - j * width / 40;
                points[(3 + 4 * this.points_num)] = height / 20 + height / 40;
                this.points_num++;
            }
        }

        //50
        //50
        for (int j = 1; j < 10; j++) {
            if (j % 5 == 0) {
                //schief
//                points[(0 + 4 * this.points_num)] = width - 2 * (width / 12) - j * width / 40 + 5 * width / 40;
//                points[(1 + 4 * this.points_num)] = height / 40;
//                points[(2 + 4 * this.points_num)] = width - 2 * (width / 12) - j * width / 40;
//                points[(3 + 4 * this.points_num)] = height / 20 + height / 40;
//                this.points_num++;
            } else {
                //"normal"
                points[(0 + 4 * this.points_num)] = width - 2 * (width / 12) - j * width / 40;
                points[(1 + 4 * this.points_num)] = 2 * height / 20 + height / 80 - j * height / 80;
                points[(2 + 4 * this.points_num)] = width - 2 * (width / 12) - j * width / 40;
                points[(3 + 4 * this.points_num)] = 1 * height / 20 + height / 80 - j * height / 80;
                this.points_num++;
            }
        }
        //100
        for (int j = 1; j < 10; j++) {
            if (j % 5 == 0) {
                //schief
                points[(0 + 4 * this.points_num)] = width - 2 * (width / 12) - j * width / 40 + 5 * width / 40;
                points[(1 + 4 * this.points_num)] = (height / 2) - height / 20 - height / 40;
                points[(2 + 4 * this.points_num)] = width - 2 * (width / 12) - j * width / 40;
                points[(3 + 4 * this.points_num)] = (height / 2) - height / 40;
                this.points_num++;
            } else {
                //"normal"
                points[(0 + 4 * this.points_num)] = width - 2 * (width / 12) - j * width / 40;
                points[(1 + 4 * this.points_num)] = (height / 2) - height / 20 - height / 40;
                points[(2 + 4 * this.points_num)] = width - 2 * (width / 12) - j * width / 40;
                points[(3 + 4 * this.points_num)] = (height / 2) - height / 40;
                this.points_num++;
            }
        }

        //team bottom
        //100
        for (int j = 1; j < 12; j++) {
            if (j % 5 == 0) {
                //schief
                points[(0 + 4 * this.points_num)] = 2 * (width / 12) + j * width / 40;
                points[(1 + 4 * this.points_num)] = height / 2 + height / 40;
                points[(2 + 4 * this.points_num)] = 2 * (width / 12) + j * width / 40 - (5 * width / 40);
                points[(3 + 4 * this.points_num)] = height / 2 + height / 20 + height / 40;
                this.points_num++;
            } else {
                //"normal"
                points[(0 + 4 * this.points_num)] = 2 * (width / 12) + j * width / 40;
                points[(1 + 4 * this.points_num)] = height / 2 + height / 40;
                points[(2 + 4 * this.points_num)] = 2 * (width / 12) + j * width / 40;
                points[(3 + 4 * this.points_num)] = height / 2 + height / 20 + height / 40;
                this.points_num++;
            }
        }
        //50
        for (int j = 1; j < 12; j++) {
            if (j % 5 == 0) {
                //schief
//                points[(0 + 4 * this.points_num)] = 2 * (width / 12) + j * width / 40;
//                points[(1 + 4 * this.points_num)] = height / 2 + height / 40;
//                points[(2 + 4 * this.points_num)] = 2 * (width / 12) + j * width / 40 - (5 * width / 40);
//                points[(3 + 4 * this.points_num)] = height / 2 + height / 20 + height / 40;
//                this.points_num++;
            } else {
                //"normal"
                points[(0 + 4 * this.points_num)] = 2 * (width / 12) + j * width / 40;
                points[(1 + 4 * this.points_num)] = height - 2 * height / 20 - height / 80 - j * height / 80;
                points[(2 + 4 * this.points_num)] = 2 * (width / 12) + j * width / 40;
                points[(3 + 4 * this.points_num)] = height - 1 * height / 20 - height / 80 - j * height / 80;
                this.points_num++;
            }
        }
        //20
        for (int j = 1; j < 10; j++) {
            if (j % 5 == 0) {
                //schief
                points[(0 + 4 * this.points_num)] = 2 * (width / 12) + j * width / 40;
                points[(1 + 4 * this.points_num)] = height - height / 40;
                points[(2 + 4 * this.points_num)] = 2 * (width / 12) + j * width / 40 - (5 * width / 40);
                points[(3 + 4 * this.points_num)] = height - height / 20 - height / 40;
                this.points_num++;
            } else {
                //"normal"
                points[(0 + 4 * this.points_num)] = 2 * (width / 12) + j * width / 40;
                points[(1 + 4 * this.points_num)] = height - height / 40;
                points[(2 + 4 * this.points_num)] = 2 * (width / 12) + j * width / 40;
                points[(3 + 4 * this.points_num)] = height - height / 20 - height / 40;
                this.points_num++;
            }
        }

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
        this._canvas.drawText(Integer.toString(resultA), this._width / 2, this._height / 2 - this.scoreTextSize, this._paint);
        this._canvas.restore();
        // draw current score of team b
        // TODO: Dynamically get Points!!!
        this._canvas.drawText(Integer.toString(50), this._width / 2, this._height / 2 + this.scoreTextSize, this._paint);
        this._paint.setTextSize(this.scoreTextSize);
        this._canvas.save();
        this._canvas.rotate(180.0F, this._width / 4, 2 * this._height / 10);
        // TODO: Dynamically get Points!!!
        this._canvas.drawText(Integer.toString(resultA), this._width / 4, 2 * this._height / 10, this._paint);
        this._canvas.restore();
        // TODO: Dynamically get Points!!!
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
                /*GlobalContext gc = (GlobalContext) ((Activity)getContext()).getApplication();
                gc.setTeam("t");*/
                Intent reqInt = new Intent(paramContext, ScoreDialog.class);
                reqInt.putExtra("team","t");
                ((Activity) paramContext).startActivityForResult(reqInt, 1);

            }
            // Team on the bottom
            if (this.zone_b_custom.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
            {
                //paramContext.startActivity(new Intent(paramContext, ScoreDialog.class));
                //277457
                //((Activity)getContext()).startActivityForResult(new Intent(paramContext, ScoreDialog.class), 0);
                Intent reqInt = new Intent(paramContext, ScoreDialog.class);
                reqInt.putExtra("team","b");
                ((Activity) paramContext).startActivityForResult(reqInt, 1);
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