/**
 * Created by suchintan on 2014-09-09.
 */
public class SessionData implements Comparable<SessionData>{
    private int day;
    private int hour;
    private int sessions;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getSessions() {
        return sessions;
    }

    public void setSessions(int sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        if(sessions != 0){

            return day + ":" + hour + ":" + sessions;
        }

        return "";
    }

    @Override
    public int compareTo(SessionData o) {
        if(sessions>o.getSessions()){
            return -1;
        }else if(sessions<o.getSessions()){
            return 1;
        }else{
            return 0;
        }
    }
}
