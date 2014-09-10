import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by suchintan on 2014-09-08.
 */
public class OptimalMessageTimeGenerator {
    private static int WINDOW_SIZE = 3;

    public static void main(String[] args) {
        List<UserSessionData> datas = getSessionData("sample_data.txt");
        System.out.println(datas);
        for(UserSessionData data : datas){
            List<SessionData> scores = new ArrayList<SessionData>();
            for(int c = 0; c < data.getSessionDataList().size()-WINDOW_SIZE; c++){
                int day = data.getSessionDataList().get(c).getDay();
                int hour = data.getSessionDataList().get(c).getHour();

                int totalsessions = 0;
                for(int d = 0; d < WINDOW_SIZE; d++){
                    totalsessions += data.getSessionDataList().get(c+d).getSessions();
                }

                SessionData score = new SessionData();
                score.setDay(day);
                score.setHour(hour);
                score.setSessions(totalsessions);

                scores.add(score);
            }
            Collections.sort(scores);
            System.out.println(scores);
            System.out.print(data.getUserid());
            for(int c = 0; c < 5 && c < scores.size(); c++){
                System.out.print(" " + scores.get(c));
            }
            System.out.println();
        }
    }

    private static List<UserSessionData> getSessionData(String filename) {
        List<UserSessionData> data = new ArrayList<UserSessionData>();

        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String s = "";
            while((s = br.readLine())!= null){
                String[] userdata = s.split(",");
                int userid = Integer.parseInt(userdata[0]);

                List<SessionData> dataList = new ArrayList<SessionData>();
                for(int c =1 ; c < userdata.length; c++){
                    SessionData sdata = new SessionData();

                    String[] rawsdata = userdata[c].split(":");
                    sdata.setDay(Integer.parseInt(rawsdata[0]));
                    sdata.setHour(Integer.parseInt(rawsdata[1]));
                    sdata.setSessions(Integer.parseInt(rawsdata[2]));
                    dataList.add(sdata);
                }

                UserSessionData sessionData = new UserSessionData();
                sessionData.setUserid(userid);
                sessionData.setSessionDataList(dataList);

                data.add(sessionData);
                break;
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return data;
    }
}
