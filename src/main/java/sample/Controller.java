package sample;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.Calendar;
import java.util.ArrayList;
//Async-things
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class Controller implements Initializable {

    @FXML
    private JFXTextField display;
    @FXML
    private JFXTextArea display2;
    @FXML
    private JFXTextArea display33;
    @FXML
    private JFXTextField display3;
    @FXML
    private JFXTextField display4;
    @FXML
    private JFXTextField calendar;
    @FXML
    private JFXTextField date;

    @FXML
    private JFXTextField c0;
    @FXML
    private JFXTextField c1;
    @FXML
    private JFXTextField c2;
    @FXML
    private JFXTextField c3;
    @FXML
    private JFXTextField c4;
    @FXML
    private JFXTextField c5;
    @FXML
    private JFXTextField c6;
    @FXML
    private JFXTextField c7;
    @FXML
    private JFXTextField c8;
    @FXML
    private JFXTextField c9;
    @FXML
    private JFXTextField c10;
    @FXML
    private JFXTextField c11;
    @FXML
    private JFXTextField c12;
    @FXML
    private JFXTextField c13;
    @FXML
    private JFXTextField c14;
    @FXML
    private JFXTextField c15;
    @FXML
    private JFXTextField c16;
    @FXML
    private JFXTextField c17;
    @FXML
    private JFXTextField c18;
    @FXML
    private JFXTextField c19;
    @FXML
    private JFXTextField c20;
    @FXML
    private JFXTextField c21;
    @FXML
    private JFXTextField c22;
    @FXML
    private JFXTextField c23;
    @FXML
    private JFXTextField c24;
    @FXML
    private JFXTextField c25;
    @FXML
    private JFXTextField c26;
    @FXML
    private JFXTextField c27;
    @FXML
    private JFXTextField c28;
    @FXML
    private JFXTextField c29;
    @FXML
    private JFXTextField c30;
    @FXML
    private JFXTextField c31;
    @FXML
    private JFXTextField c32;
    @FXML
    private JFXTextField c33;
    @FXML
    private JFXTextField c34;
    @FXML
    private JFXTextField c35;
    @FXML
    private JFXTextField c36;

    @FXML
    private JFXTextField current;

    @FXML
    private  Line line;
    @FXML
    private  Circle pivot;


    @FXML
    private  Circle circle1;
    @FXML
    private  Rectangle rect1;
    @FXML
    private  Rectangle rect2;
    @FXML
    private  Rectangle rect3;

    Calendar rn = Calendar.getInstance();
    Media pick = new Media("file:///D:/JAVA_GUI/time_keeper/src/main/resources/put.mp3"); // replace this with your own audio file
    MediaPlayer player = new MediaPlayer(pick);

    private ScheduledExecutorService ses;
    private ScheduledFuture swf;
    private Stopwatch sw;
    private List alarm = new ArrayList<Alarm> (10);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        sw = new Stopwatch();

        display.setText("00:00:00");
        display2.setText("");
        display4.setText("00:00:00");

        fillCalendar(0,0);
        ses = Executors.newScheduledThreadPool(4);
        ses.scheduleWithFixedDelay(new ClockTicker(), 0, 1, TimeUnit.SECONDS);

        System.out.println("Initialized");
    }


    public void terminateAll() {
        // Think: Maybe store all futures in an array and cancel them before initiating shutdown??
        ses.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            System.out.println("Termination started");
            if (!ses.awaitTermination(10, TimeUnit.SECONDS)) {
                ses.shutdownNow(); // Cancel currently executing tasks
                System.out.println("Forced termination required");
                // Wait a while for tasks to respond to being cancelled
                if (!ses.awaitTermination(10, TimeUnit.SECONDS))
                    System.out.println("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            System.out.println("Exception!!");
            // (Re-)Cancel if current thread also interrupted
            ses.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
        System.out.println("Terminating works!!");
    }

    class ClockTicker implements Runnable {

        public void run() {
            try {
                int old = 0;

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);
                //System.out.println(formattedDate);
                String[] arofstr = formattedDate.split(" ", 5);
                try {
                    int h = Integer.parseInt(arofstr[1].split(":")[0].trim());
                    if (old != h){
                        old = h;
                        String colour = "#0d0d0d0d";
                        if(h < 6) {
                            // Black, do nothing
                        }
                        else if(h < 10) {
                            // Sky blue
                            colour = "#99d9ea";
                        }
                        else if(h < 16) {
                            // ?
                            colour = "#fff200";
                        }
                        else if(h < 18) {
                            //orange
                            colour = "#ff7f27";
                        }
                        else if(h < 22) {
                            // blue
                            colour = "#3995d2";
                        }
                        else {
                            // navy blue
                            colour = "#222982";
                        }

                        circle1.setFill(Paint.valueOf(colour));
                        circle1.setStyle("-fx-color: black");
                        //rect1.setFill(Paint.valueOf(colour));
                        rect2.setFill(Paint.valueOf(colour));
                        rect3.setFill(Paint.valueOf(colour));
                    }
                }
                catch (Exception e) {
                    System.out.println("An exception that can be ignored...");
                    e.printStackTrace();
                }
                date.setText(arofstr[0]);
                current.setText(arofstr[1]);
            }
            catch (Exception e) {
                System.out.println("Error in ClockTicker: "+e.getMessage());
            }
        }
    }

    public void onSet(ActionEvent actionEvent) {
        //Alarm alarms0 = new Alarm(display3.getText(),"name", 0);
        int i=0;
        String [] kk = display3.getText().split(":", 3);
        if (alarm.size() == 0)
        {
            alarm.add(i, new Alarm(display3.getText(),"name", 0));

        }
        else {
            while (i < alarm.size()) {

                Alarm alarms = (Alarm) alarm.get(i);
                String[] time = alarms.getToGo().split(":");

                if (Integer.parseInt(kk[0]) == Integer.parseInt(time[0])) {
                    if (Integer.parseInt(kk[1]) > Integer.parseInt(time[1])) {
                        i++;
                        if (alarm.size() == i ) {
                            alarm.add(i , new Alarm(display3.getText(), "name", 0));
                            break;
                        }
                        continue;
                    }
                    if (Integer.parseInt(kk[1]) < Integer.parseInt(time[1])) {
                        alarm.add(i, new Alarm(display3.getText(), "name", 0));
                        break;
                    }

                }
                if (Integer.parseInt(kk[0]) < Integer.parseInt(time[0])) {
                    alarm.add(i, new Alarm(display3.getText(), "name", 0));
                    break;
                }
                if (alarm.size() == i + 1) {
                    alarm.add(i + 1, new Alarm(display3.getText(), "name", 0));
                    break;
                }
                i++;

            }

        }
         String out= "";
         int j = 0;
         while(j<alarm.size())
         {
             out= out+((Alarm) alarm.get(j)).getToGo()+"\n";
             j++;
         }
         display33.setText(out);

//        rn=Calendar.getInstance();
//        long now =rn.getTimeInMillis();
//        String alarm = display3.getText();
//        String[] stalarm = alarm.split(":", 5);
//        rn.set(Calendar.HOUR_OF_DAY,Integer.parseInt(stalarm[0]));
//        rn.set(Calendar.MINUTE,Integer.parseInt(stalarm[1]));
//        rn.set(Calendar.SECOND,00);
//
//        System.out.println((rn.getTimeInMillis() - now)/1000);
//        ses.schedule(new PlaySound(), (rn.getTimeInMillis() - now), TimeUnit.MILLISECONDS);
    }

    class Timer implements Runnable {
        private int toGo;

        Timer(int tg) {
            this.toGo = tg;
        }

        public void run() {
            if(toGo == 0) {
                return;
            }

            try {
                this.toGo--;
                if(toGo == 0){
                    if(player.getStatus() != MediaPlayer.Status.PLAYING) {
                        player.play();
                    }
                    ses.schedule(new Snooze(), 30, TimeUnit.SECONDS);
                }

                // UI display code.
                display4.setText(String.format("%02d", toGo / 3600) + ":"
                        + String.format("%02d", toGo / 60) + ":"
                        + String.format("%02d", toGo % 60));
            } catch (Exception e) {
                System.out.println("Error in Timer: "+e.getMessage());
            }
        }
    }

    class PlaySound implements Runnable {

        public  void run() {
            try {
                // System.out.println((rn.getTimeInMillis() - now));
                if(player.getStatus() != MediaPlayer.Status.PLAYING) {
                    player.play();
                }
                ses.schedule(new Snooze(), 30, TimeUnit.SECONDS);
            }
            catch (Exception e) {
                System.out.println("Error in PlaySound: "+e.getMessage());
            }
        }
    }

    class Snooze implements Runnable {

        public void run() {
            if(player.getStatus() != MediaPlayer.Status.STOPPED) {
                player.stop();
                ses.schedule(new PlaySound(), 10, TimeUnit.SECONDS);
            }
        }
    }

    class Alarm {
        private String at ;
        private String name;
        private ScheduledFuture sf;

        Alarm(String at, String name, int recurringFreq) {
            this.at = at;
            int hh = 0, min = 0;
            String []at1 = at.split(":");
            this.name = name;
            long dif =0;
            hh = Integer.parseInt(at1[0]);
            min = Integer.parseInt(at1[1]);
            Calendar rn = Calendar.getInstance();
            if(hh < rn.get(Calendar.HOUR_OF_DAY) ||(hh == rn.get(Calendar.HOUR_OF_DAY) &&min < rn.get(Calendar.MINUTE))) {
                dif = rn.getTimeInMillis();
                rn.set(Calendar.HOUR_OF_DAY, hh);
                rn.set(Calendar.MINUTE, min);
                rn.set(Calendar.SECOND, 00);
                rn.set(Calendar.DATE,rn.get(Calendar.DATE)+1);
                System.out.println(rn.getTimeInMillis());
                System.out.println(dif);
                dif= rn.getTimeInMillis()-dif;
            }
            else{
                dif=rn.getTimeInMillis();
                rn.set(Calendar.HOUR_OF_DAY, hh);
                rn.set(Calendar.MINUTE, min);
                rn.set(Calendar.SECOND, 00);
                System.out.println(rn.getTimeInMillis());
                System.out.println(dif);
                dif= rn.getTimeInMillis()-dif;
            }
            System.out.println(dif);
            this.sf = ses.schedule(new PlaySound(),  dif, TimeUnit.MILLISECONDS);
        }

        public String getToGo() {
            return this.at;
        }

        public String getName() {
            return this.name;
        }

        public void cancelAlarm() {
            this.sf.cancel(false);
        }
    }

    public void onReset(ActionEvent actionEvent) {
        if(swf != null && !swf.isDone()) {
            swf.cancel(false);
            display.setText("00:00:00");
            display2.setText("");
        }
        if(swf != null) {
            sw.restartCount();
            display.setText("00:00:00");
            display2.setText("");
        }
    }

    public void onRe(ActionEvent actionEvent) {
        player.stop();
    }

    public void onRESET(ActionEvent actionEvent) {
        player.stop();

    }

    public void onPause(ActionEvent actionEvent) {
        String s = display2.getText();
        display2.setText(display.getText() + "\n" + s);
    }

    public void onStart(ActionEvent actionEvent) {
        try {
            if(swf == null || swf.isDone()) {
                swf = ses.scheduleWithFixedDelay(sw, 0, 1, TimeUnit.SECONDS);
            }
            else if(swf != null && !swf.isDone()) {
                swf.cancel(false);
            }
        }
        catch(Exception e) {
            System.out.println("Error onStart: "+e.getMessage());
        }
    }

    class Stopwatch implements Runnable {
        private int at = 0;

        Stopwatch() {
            this.at = 0;
        }

        public void run() {
            try {
                this.at++;

                // UI display code.
                display.setText(String.format("%02d", this.at / 3600) + ":"
                        + String.format("%02d", this.at / 60) + ":"
                        + String.format("%02d", this.at % 60));
            } catch (Exception e) {
                System.out.println("Error in Timer: "+e.getMessage());
            }
        }

        public int lap() {
            return this.at;
        }

        public void restartCount() {
            this.at = 0;
        }
    }

    public void timer(ActionEvent actionEvent) {
        String[] arrOfStr = display4.getText().split(":", 5);
        int secT=Integer.parseInt(arrOfStr[2]);
        int minT=Integer.parseInt(arrOfStr[1]);
        int hrT=Integer.parseInt(arrOfStr[0]);

        int duration = hrT*3600 + minT*60 + secT;
        ses.schedule(new Canceller(ses.scheduleWithFixedDelay(new Timer(duration), 0, 1, TimeUnit.SECONDS)), duration+2, TimeUnit.SECONDS);
    }

    class Canceller implements Runnable {
        private final ScheduledFuture future;

        Canceller(ScheduledFuture future) {
            this.future = future;
        }

        public void run() {
            future.cancel(false);
        }
    }

    public void fillCalendar(int m, int y){
        rn=Calendar.getInstance();
        if( m!= 0&& y!=0) {
            rn.set(Calendar.MONTH , m-1);
            rn.set(Calendar.YEAR , y);
        }

        int i=1;
        rn.set(Calendar.DATE,1);
        int date= rn.get(Calendar.DAY_OF_WEEK);
        switch(date-1) {
            case 0:
                c0.setText(""+i);
                i++;

            case 1:
                if( i ==1)
                {
                    c0.setText("");
                }
                c1.setText(""+i);
                i++;

            case 2:
                if( i ==1)
                {
                    c0.setText("");
                    c1.setText("");
                }
                c2.setText(""+i);
                i++;

            case 3:
                if( i ==1)
                {
                    c0.setText("");
                    c1.setText("");
                    c2.setText("");
                }
                c3.setText(""+i);
                i++;

            case 4:
                if( i ==1)
                {
                    c0.setText("");
                    c1.setText("");
                    c2.setText("");
                    c3.setText("");
                }
                c4.setText(""+i);
                i++;

            case 5:
                if( i ==1)
                {
                    c0.setText("");
                    c1.setText("");
                    c2.setText("");
                    c3.setText("");
                    c4.setText("");
                }
                c5.setText(""+i);
                i++;

            case 6:
                if( i ==1)
                {
                    c0.setText("");
                    c1.setText("");
                    c2.setText("");
                    c3.setText("");
                    c4.setText("");
                    c5.setText("");
                }
                c6.setText(""+i);
                i++;

            case 7:
                c7.setText(""+i);
                i++;

            case 8:
                c8.setText(""+i);
                i++;

            case 9:
                c9.setText(""+i);
                i++;

            case 10:
                c10.setText(""+i);
                i++;

            case 11:
                c11.setText(""+i);
                i++;

            case 12:
                c12.setText(""+i);
                i++;

            case 13:
                c13.setText(""+i);
                i++;

            case 14:
                c14.setText(""+i);
                i++;

            case 15:
                c15.setText(""+i);
                i++;

            case 16:
                c16.setText(""+i);
                i++;

            case 17:
                c17.setText(""+i);
                i++;

            case 18:
                c18.setText(""+i);
                i++;

            case 19:
                c19.setText(""+i);
                i++;

            case 20:
                c20.setText(""+i);
                i++;

            case 21:
                c21.setText(""+i);
                i++;

            case 22:
                c22.setText(""+i);
                i++;

            case 23:
                c23.setText(""+i);
                i++;

            case 24:
                c24.setText(""+i);
                i++;

            case 25:
                c25.setText(""+i);
                i++;

            case 26:
                c26.setText(""+i);
                i++;

            case 27:
                c27.setText(""+i);
                i++;

            case 28:
                rn.set(Calendar.DATE, i);
                if(rn.get(Calendar.DATE) == 1) {
                    c28.setText("");
                    c29.setText("");
                    c30.setText("");
                    c31.setText("");
                    c32.setText("");
                    c33.setText("");
                    c34.setText("");
                    c35.setText("");
                    c36.setText("");
                    break;
                }
                c28.setText(""+i);
                i++;

            case 29:
                rn.set(Calendar.DATE, i);
                if(rn.get(Calendar.DATE) == 1) {
                    c29.setText("");
                    c30.setText("");
                    c31.setText("");
                    c32.setText("");
                    c33.setText("");
                    c34.setText("");
                    c35.setText("");
                    c36.setText("");
                    break;
                }
                c29.setText(""+i);
                i++;

            case 30:
                rn.set(Calendar.DATE, i);
                if(rn.get(Calendar.DATE) == 1) {
                    c30.setText("");
                    c31.setText("");
                    c32.setText("");
                    c33.setText("");
                    c34.setText("");
                    break;
                }
                c30.setText(""+i);
                i++;

            case 31:
                rn.set(Calendar.DATE, i);
                if(rn.get(Calendar.DATE) == 1) {
                    c31.setText("");
                    c32.setText("");
                    c33.setText("");
                    c34.setText("");
                    c35.setText("");
                    c36.setText("");
                    break;
                }
                c31.setText(""+i);
                i++;

            case 32:
                rn.set(Calendar.DATE, i);
                if(rn.get(Calendar.DATE) == 1) {
                    c32.setText("");
                    c33.setText("");
                    c34.setText("");
                    c35.setText("");
                    c36.setText("");
                    break;
                }
                c32.setText(""+i);
                i++;

            case 33:
                rn.set(Calendar.DATE, i);
                if(rn.get(Calendar.DATE) == 1) {
                    c33.setText("");
                    c34.setText("");
                    c35.setText("");
                    c36.setText("");
                    break;
                }
                c33.setText(""+i);
                i++;

            case 34:
                rn.set(Calendar.DATE, i);
                if(rn.get(Calendar.DATE) == 1) {
                    c34.setText("");
                    c35.setText("");
                    c36.setText("");
                    break;
                }
                c34.setText(""+i);
                i++;
            case 35:
                rn.set(Calendar.DATE, i);
                if(rn.get(Calendar.DATE) == 1) {
                    c35.setText("");
                    c36.setText("");
                    break;
                }
                c35.setText(""+i);
                i++;
            case 36:
                rn.set(Calendar.DATE, i);
                if(rn.get(Calendar.DATE) == 1) {
                    c36.setText("");
                    break;
                }
                c36.setText(""+i);
                i++;
        }

    }
    public void cSearch(ActionEvent actionEvent) {
        String[] cal=calendar.getText().split("/",5);

        if(cal.length != 2) {
            return;
        }
        else {
            try {
                int m = Integer.parseInt(cal[0]);
                int y = Integer.parseInt(cal[1]);

                fillCalendar(m, y);
            }
            catch(Exception e) {
                System.out.println("Error encountered while converting to int: "+e.getMessage());
                calendar.setText("");
            }
        }
    }

}
