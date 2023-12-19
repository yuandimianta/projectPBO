import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Session implements Runnable {


    private static int sessionTime;
    private static JFrame frame;
    private static Thread thread;
    public Session(){

        sessionTime = 180;
        thread = new Thread(this);

    }
    
    public void run(){
        while(thread!=null){
            try{
                thread.sleep(1000);
                sessionTime--;
                System.out.println(sessionTime);
                if(sessionTime==0){
                    Conn.setCardNumber(0);
                    stop();
                    JOptionPane.showMessageDialog(null, "Session Expired");
                    new LoginPage().setVisible(true);
                    frame.dispose();
                    // System.exit(0);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void stop(){
        thread = null;
    }
    public static void startSession(){
        sessionTime = 180;
        if (thread == null) {
            
            thread = new Thread(new Session());
            
        }
        thread.start();
    }

    public static void setFrame(JFrame frameThis){
        frame = frameThis;
    }
}
