package guntersoft.getfit101;

/**
 * Created by gunte on 7/20/2016.
 */
public interface IWorkout {

    void ChangerBoutonPause();
    void ChangerBoutonStop();
    void RefreshDurationData(String duration);
    void RefreshCaloriesData(int calories);
    void RefreshHeartRate(int heartRateBPM);
    void RefreshIntervalDurationData(long intervalTime);

}
