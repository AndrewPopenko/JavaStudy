package horstman.part.interfaces.callback;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(10000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Terminate the program?");
        System.exit(0);
    }
}

class TalkingClock {
    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    private int interval;
    private boolean beep;

    private class TimePrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Date now = new Date();
            System.out.println("Bell, time: " + now);
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}
