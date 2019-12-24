package com.smx.handle;

import com.smx.view.CalcWin;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class HandleOperator extends HandleEvent {

    public HandleOperator(CalcWin calcWin) {
        super(calcWin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        JButton btn=(JButton)e.getSource();
        char cmd=btn.getText().trim().charAt(0);
        if(!calcWin.calculator.hasOperators()){
            calcWin.calculator.pushCurrent(cmd);
            calcWin.calculator.hasOperator=true;
            calcWin.calculator.current_size=calcWin.calculator.getCurrentData().length();
            showMessage();
        }else if(calcWin.calculator.hasOperator){
            calcWin.calculator.changeOperator(cmd);
            showMessage();
        }
    }



}
