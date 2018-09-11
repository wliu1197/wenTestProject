/**
 * Created by wliu on 25/03/15.
 */
public class testPrivParams {
    boolean showSummaries = true;
    public void setShowSummaries(boolean showSummaries) {
            this.showSummaries = showSummaries;
        }
    public boolean isShowSummaries() {
        return showSummaries;
    }

    public static void main(String [] args){
        testPrivParams  ts = new testPrivParams ();
        System.out.println(ts.isShowSummaries());
        ts.setShowSummaries(false);
        System.out.println(ts.isShowSummaries());

    }

}
