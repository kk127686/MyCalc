package com.smx.handle;

import com.smx.view.CalcWin;

import java.awt.event.ActionEvent;

public class HandleSqrt extends HandleEvent {
    private String old_str;
    private Double result;
    private char cmd;
    private char[] array;
    public HandleSqrt(CalcWin calcWin) {
        super(calcWin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        cmd=e.getActionCommand().charAt(0);
        calcWin.calculator.insertOperator(cmd);
        old_str=calcWin.calc_input_text.getText().trim();
        result=Math.sqrt(Double.parseDouble(old_str));
        array=result.toString().toCharArray();
        calcWin.calculator.dataClear();
        for(int i=0;i<array.length;i++){
            calcWin.calculator.pushCurrent(array[i]);
        }
        showMessage();
    }
}
