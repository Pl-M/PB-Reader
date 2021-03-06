/*
 * Copyright (c) 2016-2018 Pavel_M-v.
 */
package pl.bookjpreader.gui.simplewidgets;

import java.util.Calendar;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class ClockWidget extends Label{

    public ClockWidget(int fontSize) {
        startTicking();

        this.setFont(new Font(fontSize));
        this.setPadding(new Insets(0, 5, 0, 5));
    }
    private void startTicking(){
        final Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                m -> changeTime()),
                new KeyFrame(Duration.seconds(1))
              );
              timeline.setCycleCount(Animation.INDEFINITE);
              timeline.play();
             }
    private void changeTime(){
        final Calendar time = Calendar.getInstance();
        String hour, min;
        Integer h = time.get(Calendar.HOUR);

        if (time.get(Calendar.AM_PM) == Calendar.PM)
            h += 12;
        hour = addZero(h);
        min =  addZero(time.get(Calendar.MINUTE));

        setText(hour + ":" + min);
    }
    private String addZero(final int value){
        final String result;
        if (value < 10) {
            result = "0" + value;
        } else {
            result = String.valueOf(value);
        }

        return result;
    }
}
