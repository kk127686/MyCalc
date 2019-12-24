package com.smx.handle;

import com.smx.view.CalcWin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class HandleSave extends HandleEvent {

    public HandleSave(CalcWin calcWin) {
        super(calcWin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        JFileChooser jFileChooser=new JFileChooser();
        int state=jFileChooser.showSaveDialog(null);
        File file=jFileChooser.getSelectedFile();
        if(file!=null&&state==JFileChooser.APPROVE_OPTION){
            String content=calcWin.calculator.getCurrentData();
            StringReader stringReader=new StringReader(content);
            try {
                BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));
                int length=0;
                char[] buf=new char[256];
                while((length=stringReader.read(buf))!=-1){
                    bufferedWriter.write(buf,0,length);
                }
                bufferedWriter.close();
                stringReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
