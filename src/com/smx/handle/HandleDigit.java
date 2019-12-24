package com.smx.handle;

import com.smx.view.CalcWin;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class HandleDigit extends HandleEvent {

    public HandleDigit(CalcWin calcWin) {
        super(calcWin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        JButton btn=(JButton) e.getSource();
        String cmdName=btn.getText().trim();
        char cmd=cmdName.charAt(0);
        calcWin.calculator.pushCurrent(cmd);
        showMessage();
    }

}
