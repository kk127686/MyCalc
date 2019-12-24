package com.smx.handle;

import com.smx.view.CalcWin;

import java.awt.event.ActionEvent;

public class HandleX extends HandleEvent {
    private String old_str;
    private Double result;
    private char cmd;
    private char[] array;
    public HandleX(CalcWin calcWin) {
        super(calcWin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        cmd=e.getActionCommand().charAt(0);
        calcWin.calculator.insertOperator(cmd);
        old_str=calcWin.calc_input_text.getText().trim();
        result=1/Double.parseDouble(old_str);
        calcWin.calculator.dataClear();
        array=result.toString().toCharArray();
        for(int i=0;i<array.length;i++){
            calcWin.calculator.pushCurrent(array[i]);
        }
        showMessage();
    }
}
