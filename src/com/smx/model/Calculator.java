package com.smx.model;

import com.smx.Compute;
import com.smx.Constant;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.Stack;

public class Calculator {

    Stack<Character> data1;
    Stack<Character> data2;
    public boolean hasOperator=false;
    public int current_size=0;
    public double result=0;

    public Calculator(){
        init();
    }

    private void init(){
        data1=new Stack<>();
        data2=new Stack<>();
    }

    public void pushCurrent(Character c){
        data1.push(c);
    }

    public String getCurrentData(){
        return stackToString(data1);
    }

    public String stackToString(Stack<Character> stack){
        if(!stack.isEmpty()){
            StringBuffer buf=new StringBuffer();
            for(int i=0;i<stack.size();i++){
                buf.append(stack.get(i));
            }
            return new String(buf);
        }else{
            return "0";
        }
    }

    public void backSpace(){
        if(!data1.isEmpty()){
            data1.pop();
        }
    }

    public void dataClear(){
        while (!data1.isEmpty()){
            data1.pop();
        }
    }

    public boolean hasOperators(){
        boolean hasOperator=false;
        for(int i=0;i<Constant.OPERATOR.length;i++){
            int x=data1.search(Constant.OPERATOR[i]);
            if(x!=-1){
                hasOperator=true;
                break;
            }
        }
        return hasOperator;
    }

    public void toCopy(String value){
        Clipboard clipboard= Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText=new StringSelection(value);
        clipboard.setContents(tText,null);
    }
    public void getResult(double x1, char op,double x2){
        if(op=='+'){
            this.result=x1+x2;
        }else if(op=='-'){
            this.result=x1-x2;
        }else if(op=='*'){
            this.result=x1*x2;
        }else if(op=='/'){
            this.result=x1/x2;
        }
    }
    public void insertOperator(Character character){
        data1.add(0,character);
    }
    public void changeOperator(Character character){
        data1.set(current_size-1,character);
    }
    public void toZhengshu(){
        data1.remove(0);
    }
    public void updateResStack(String values){
        char[] arrays=values.toCharArray();
        for(int i=0;i<arrays.length;i++){
            data2.add(arrays[i]);
        }
    }
    public String getResString(){
        return stackToString(data2);
    }
}
