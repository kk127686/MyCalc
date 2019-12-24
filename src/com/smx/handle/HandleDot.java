package com.smx.handle;

import com.smx.view.CalcWin;

import java.awt.event.ActionEvent;

public class HandleDot extends HandleEvent {
    private String old_str;
    private String new_str;
    public HandleDot(CalcWin calcWin) {
        super(calcWin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        char cmd=e.getActionCommand().charAt(0);
        old_str=calcWin.calc_text.getText();
        new_str=calcWin.calc_input_text.getText();
        if(old_str.contains(".")){
            return;
        }else if(new_str.contains(".")){
            return;
        }else{
            calcWin.calculator.pushCurrent(cmd);
        }
        showMessage();
    }
}
