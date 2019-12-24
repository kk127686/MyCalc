package com.smx.handle;


import com.smx.view.CalcWin;
import java.awt.event.ActionEvent;

public class HandleEqual extends HandleEvent {

    String old_str;
    String new_str;
    String arrays;
    char operator;
    double x1,x2,result;
    public HandleEqual(CalcWin calcWin) {
        super(calcWin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        old_str=calcWin.calc_text.getText().trim();
        operator=old_str.charAt(old_str.length()-1);
        old_str=old_str.substring(0,old_str.length()-1);
        new_str=calcWin.calc_input_text.getText().trim();
        try {
            x1=Double.parseDouble(old_str);
            x2=Double.parseDouble(new_str);
            calcWin.calculator.getResult(x1,operator,x2);
            arrays=calcWin.calculator.getCurrentData()+"="+calcWin.calculator.result;
            calcWin.calculator.updateResStack(arrays);
            calcWin.calc_history.setText(calcWin.calculator.getResString());
        }catch (NumberFormatException e1){
            calcWin.calc_history.setText("输入数据不合法");
        }
    }
}
