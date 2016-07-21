package guntersoft.getfit101.controllers;

import android.os.Handler;
import android.view.View;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import guntersoft.getfit101.IWorkout;
import guntersoft.getfit101.Workout;
import guntersoft.getfit101.model.entities.WorkoutEntity;
import guntersoft.getfit101.common.Constantes.ActivityStatus;

/**
 * Created by gunte on 7/20/2016.
 */
public class WorkoutController {

    private WorkoutEntity model;
    private IWorkout view;

    private ActivityStatus _workoutStatus = ActivityStatus.Inactive;

    Timer timer;
    TimerTask timerTask;

    Date workoutStartDate = null;

    final Handler handler = new Handler();

    //region Constructeurs

    public WorkoutController(WorkoutEntity model, IWorkout view) {
        this.model = model;
        this.view = view;
    }

    //endregion

    public void AppuyerBoutonWorkout() {
        switch (_workoutStatus) {
            case Inactive: _workoutStatus = ActivityStatus.Active;
                workoutStartDate = Calendar.getInstance().getTime();
                startTimer();
                break;
            case Active: _workoutStatus = ActivityStatus.Pause;
                stoptimertask();
                break;
            case Pause: _workoutStatus = ActivityStatus.Active;
                startTimer();
                break;
        }
        ChangeWorkoutStatus(_workoutStatus);
    }

    private void ChangeWorkoutStatus(ActivityStatus newStatus) {
        switch (newStatus) {
            case Active: view.ChangerBoutonPause();
                break;
            case Pause: view.ChangerBoutonStop();
                break;
        }
    }


    //region Timer methods
    private void startTimer() {
        timer = new Timer();
        initializeTimerTask();
        timer.schedule(timerTask, 0, 1000);
    }

    public void stoptimertask(){
        if(timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void initializeTimerTask() {
        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        model.setDuration(model.getDuration() + 1000);
                        String durationTimeFormat = null;
                        durationTimeFormat = formatInterval(model.getDuration());
                        view.RefreshDurationData(durationTimeFormat);
                    }
                });
            }
        };
    }

    private static String formatInterval(final long value) {

        final long hr = TimeUnit.MILLISECONDS.toHours(value);
        final long min = TimeUnit.MILLISECONDS.toMinutes(value - TimeUnit.HOURS.toMillis(hr));
        final long sec = TimeUnit.MILLISECONDS.toSeconds(value - TimeUnit.HOURS.toMillis(hr) - TimeUnit.MINUTES.toMillis(min));
        return String.format("%02d:%02d:%02d", hr, min, sec);
    }

    //endregion

}
