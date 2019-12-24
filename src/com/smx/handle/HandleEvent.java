package com.smx.handle;

import com.smx.view.CalcWin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandleEvent implements ActionListener {
    CalcWin calcWin;
    String old_str;
    String new_str;
    String input_str;
    public HandleEvent(CalcWin calcWin) {
        this.calcWin = calcWin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void showMessage()
    {
        if(calcWin.calculator.hasOperator){
            old_str=calcWin.calculator.getCurrentData();
            try {
                new_str=old_str.substring(0,calcWin.calculator.current_size);
                input_str=old_str.substring(calcWin.calculator.current_size,calcWin.calculator.getCurrentData().length());
            }catch (StringIndexOutOfBoundsException exception){
                new_str="0";
                input_str="0";
            }
            calcWin.calc_text.setText(new_str);
            calcWin.calc_input_text.setText(input_str);
            calcWin.calc_history.setText(calcWin.calculator.getCurrentData());
        }else{
            calcWin.calc_input_text.setText(calcWin.calculator.getCurrentData());
            calcWin.calc_history.setText(calcWin.calculator.getCurrentData());
        }
    }
}
