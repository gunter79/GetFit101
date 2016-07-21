package guntersoft.getfit101;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import guntersoft.getfit101.common.Constantes.ActivityStatus;
import guntersoft.getfit101.controllers.WorkoutController;
import guntersoft.getfit101.model.entities.WorkoutEntity;

public class Workout
        extends AppCompatActivity
        implements IWorkout {

    //region Members
    private ImageView imgPlay = null;
    private TextView tvDuration = null;
    private TextView tvDistance = null;
    private TextView tvCalories = null;
    private TextView tvHeartRate = null;
    private TextView tvSport = null;
    private WorkoutController controller = null;
    private WorkoutEntity workout = new WorkoutEntity();
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        controller = new WorkoutController(workout, this);

        tvDuration = (TextView) findViewById(R.id.duration);
        tvDistance = (TextView) findViewById(R.id.distance);
        tvCalories = (TextView) findViewById(R.id.calories);
        tvHeartRate = (TextView) findViewById(R.id.heartRate);
        tvSport = (TextView) findViewById(R.id.sport);
        imgPlay = (ImageView) findViewById(R.id.img_play);
        imgPlay.setClickable(true);
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.AppuyerBoutonWorkout();
            }
        });
    }

    @Override
    public void ChangerBoutonPause() {
        imgPlay.setImageResource(R.drawable.workoutpausebutton);
    }

    @Override
    public void ChangerBoutonStop() {
        imgPlay.setImageResource(R.drawable.workoutplaystop);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_workout, menu);
        return true;
    }

    //region IWorkout
    @Override
    public void RefreshDurationData(String duration)
    {
        tvDuration.setText(duration);
    }

    @Override
    public void RefreshIntervalDurationData(long intervalTime){

    }

    @Override
    public void RefreshHeartRate(int heartRateBPM) {

    }

    @Override
    public void RefreshCaloriesData(int calories) {

    }

    //endregion

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
