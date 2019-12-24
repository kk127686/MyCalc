package com.smx.handle;

import com.smx.view.CalcWin;

import java.awt.event.ActionEvent;

public class HandleDot extends HandleEvent {
    private String new_str;
    public HandleDot(CalcWin calcWin) {
        super(calcWin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        char cmd=e.getActionCommand().charAt(0);
        if(calcWin.calculator.hasOperator){
            new_str=calcWin.calc_input_text.getText();
            if(!new_str.contains(".")){
                calcWin.calculator.pushCurrent(cmd);
            }
        }else{
            calcWin.calculator.pushCurrent(cmd);
        }
        showMessage();
    }
}
