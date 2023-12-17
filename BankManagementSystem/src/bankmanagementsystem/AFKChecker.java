import javax.swing.JOptionPane;

public class AFKChecker implements Runnable {

    private static int afkTime;
    private static Thread thread;

    public AFKChecker() {

        afkTime = 20;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        while (thread != null) {
            try {
                thread.sleep(1000);
                afkTime--;
                System.out.println(afkTime);
                if (afkTime == 0) {
                    Conn.cardNumber = 0;
                    stop();
                    int result = JOptionPane.showConfirmDialog(null, "Apakah anda perlu waktu tambahan?",
                            "Konfirmasi",
                            JOptionPane.YES_NO_OPTION);

                    if (result == JOptionPane.YES_OPTION) {
                        startAfkCheck();
                    } else if (result == JOptionPane.NO_OPTION){
                       System.exit(0);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void stop() {
        thread = null;
    }

    public static void startAfkCheck() {
        afkTime = 20;
        if (thread == null) {
            thread = new Thread(new AFKChecker());
        }
        thread.start();
    }

    public static void resetTimer() {
        afkTime = 20;
    }

}
