package com.smx.handle;

import com.smx.view.CalcWin;

import java.awt.event.ActionEvent;

public class HandleCopy extends HandleEvent {

    public HandleCopy(CalcWin calcWin) {
        super(calcWin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String values=calcWin.calc_history.getText();
        calcWin.calculator.toCopy(values);
    }
}
