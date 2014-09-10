import java.util.List;

/**
 * Created by suchintan on 2014-09-09.
 */
public class UserSessionData {
    private int userid;
    private List<SessionData> sessionDataList;

    public List<SessionData> getSessionDataList() {
        return sessionDataList;
    }

    public void setSessionDataList(List<SessionData> sessionDataList) {
        this.sessionDataList = sessionDataList;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        String s = userid + " " + sessionDataList.toString();
        return s;
    }
}
