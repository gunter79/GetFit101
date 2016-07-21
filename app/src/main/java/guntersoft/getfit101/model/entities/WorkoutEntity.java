package guntersoft.getfit101.model.entities;

import java.util.Date;


/**
 * Created by gunte on 7/20/2016.
 */
public class WorkoutEntity {

    private Date startDateTime ;
    private Long duration;
    private Double distance;
    private String distanceUnit;
    private Double averageSpeed;
    private Double averagePace;
    private Double maxSpeed;
    private Double maxPace;
    private int calories;
    private int averageHeartRate;
    private int maxHeartRate;
    private int minAltitude;
    private int maxAltitude;
    private int totalAscent;
    private int totalDescent;
    /*TODO - Weather informations : degree, degree system, wind, humidity, weather type*/
    /*TODO - Route map*/
    /*TODO - Graph : Speed, Pace, Altitude, Heart Rate*/

    public Date getStartDateTime(){return startDateTime;} ;
    public void setStartDateTime(Date value){this.startDateTime = value;}
    public Long getDuration(){return duration;};
    public void setDuration(Long value){this.duration = value;}
    public Double getDistance(){return distance;};
    public void setDistance(Double value){this.distance = value;}
    public String getDistanceUnit(){return distanceUnit;};
    public void setDistanceUnit(String value){this.distanceUnit = value;}
    public Double getAverageSpeed(){return averageSpeed;};
    public void setAverageSpeed(Double value){this.averageSpeed = value;}
    public Double getAveragePace(){return averagePace;};
    public void setAveragePace(Double value){this.averagePace = value;}
    public Double getMaxSpeed(){return maxSpeed;};
    public void setMaxSpeed(Double value){this.maxSpeed = value;}
    public Double getMaxPace(){return maxPace;};
    public void setMaxPace(Double value){this.maxPace = value;}
    public int getCalories(){return calories;};
    public void setCalories(int value){this.calories = value;}
    public int getAverageHeartRate(){return averageHeartRate;};
    public void setAverageHeartRate(int value){this.averageHeartRate = value;}
    public int getMaxHeartRate(){return maxHeartRate;};
    public void setMaxHeartRate(int value){this.maxHeartRate = value;}
    public int getMinAltitude(){return minAltitude;};
    public void setMinAltitude(int value){this.minAltitude = value;}
    public int getMaxAltitude(){return maxAltitude;};
    public void setMaxAltitude(int value){this.maxAltitude = value;}
    public int getTotalAscent(){return totalAscent;};
    public void setTotalAscent(int value){this.totalAscent = value;}
    public int getTotalDescent(){return totalAscent;};
    public void setTotalDescent(int value){this.totalDescent = value;}

    public WorkoutEntity(){
        this.duration = (long)0;
        this.distance = (double)0;
    }
}
