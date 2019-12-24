package com.smx.handle;

import com.smx.view.CalcWin;

import java.awt.event.ActionEvent;

public class HandleZhengfu extends HandleEvent {
    private String old_str;
    private Double result;
    public HandleZhengfu(CalcWin calcWin) {
        super(calcWin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        try {
            old_str=calcWin.calc_input_text.getText().trim();
        }catch (NumberFormatException e1){
            old_str=calcWin.calc_text.getText().trim();
        }
        result=Double.parseDouble(old_str);
        if(result>0){
            calcWin.calculator.insertOperator('-');
        }else if(result<0){
            calcWin.calculator.toZhengshu();
        }
        showMessage();
    }
}
