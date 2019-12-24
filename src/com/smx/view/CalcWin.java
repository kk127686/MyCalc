package com.smx.view;

import com.smx.Constant;
import com.smx.handle.*;
import com.smx.model.Calculator;

import javax.swing.*;
import java.awt.*;

public class CalcWin extends JFrame {

    JButton[] btnDigit;//数字按钮
    JButton btn_save,btn_copy,btn_clear;//保存 复制 清空
    JButton[] btnOp;//运算符
    JButton btn_back,btn_c,btn_x;//退格，清空，1/x
    JButton btn_sqrt,btn_zhengfu,btn_equal;//开方 正负 等于
    JButton btn_dot;//点

    public JLabel calc_text,calc_input_text;//
    public JTextArea calc_history;
    public Calculator calculator;//数据存储

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem file_menu_item;

    public CalcWin(){
        try {
//            for (UIManager.LookAndFeelInfo info : getInstalledLookAndFeels()) {
//                System.out.println(info.getName());
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//
//            }
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        }catch(Exception e) {
            System.out.println(e);
        }
        setTitle("计算器");
        setCenter(500,650);
        calculator=new Calculator();
        initView();
        initEvent();
        setVisible(true);
    }



    private void setCenter(int width, int height) {
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth=(int)dimension.getWidth();
        int screenHeight=(int)dimension.getHeight();
        int yPos=(screenHeight-height)/2;
        int xPos=(screenWidth-width)/2;
        setBounds(xPos,yPos,width,height);
        setLayout(new BorderLayout());
    }


    private void initView() {
        btnDigit=new JButton[10];
        JPanel topJanel,centerJanel,bottomJanel;
        Font font_btn,font_calc;

        font_btn=new Font("Cambria",Font.BOLD,20);
        font_calc=new Font("Cambria",Font.BOLD,28);

        /**
         *菜单
         */
        menuBar=new JMenuBar();
        menu=new JMenu("文件");
        file_menu_item=new JMenuItem("保存");
        menu.add(file_menu_item);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        /**
         * 顶部布局
         */

        topJanel=new JPanel(new GridLayout(3,1,2,2));
        topJanel.setPreferredSize(new Dimension(350,100));
        topJanel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.YELLOW));
        calc_text=new JLabel("0",JLabel.RIGHT);
        calc_text.setFont(font_calc);
        calc_input_text=new JLabel("",JLabel.RIGHT);
        calc_input_text.setFont(font_calc);

        calc_history=new JTextArea();
        calc_history.setFont(font_btn);
        calc_history.setEditable(false);
        topJanel.add(calc_text);
        topJanel.add(calc_input_text);
        topJanel.add(calc_history);
        this.add(topJanel,BorderLayout.NORTH);

        /**
         * 中部布局
         */

        GridLayout gridLayout=new GridLayout(5,5,5,5);
        centerJanel=new JPanel(gridLayout);
        centerJanel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.YELLOW));
        btn_back=new JButton("←");
        btn_back.setFont(font_btn);
        btn_c=new JButton("C");
        btn_c.setFont(font_btn);
        btn_x=new JButton("1/X");
        btn_x.setFont(font_btn);
        btn_sqrt=new JButton("√");
        btn_sqrt.setFont(font_btn);
        btn_zhengfu=new JButton("±");
        btn_zhengfu.setFont(font_btn);
        for(int i=0;i<10;i++){
            btnDigit[i]=new JButton(String.valueOf(i));
            btnDigit[i].setFont(font_btn);
        }
        btnOp=new JButton[4];
        for(int i=0;i<4;i++){
            btnOp[i]=new JButton(Constant.OPERATOR[i].toString());
            btnOp[i].setFont(font_btn);
        }
        btn_equal=new JButton("=");
        btn_equal.setFont(font_btn);
        btn_dot=new JButton(".");
        btn_dot.setFont(font_btn);

        centerJanel.add(btnDigit[7]);
        centerJanel.add(btnDigit[8]);
        centerJanel.add(btnDigit[9]);
        centerJanel.add(btnOp[0]);
        centerJanel.add(btn_back);

        centerJanel.add(btnDigit[4]);
        centerJanel.add(btnDigit[5]);
        centerJanel.add(btnDigit[6]);
        centerJanel.add(btnOp[1]);
        centerJanel.add(btn_c);


        centerJanel.add(btnDigit[1]);
        centerJanel.add(btnDigit[2]);
        centerJanel.add(btnDigit[3]);
        centerJanel.add(btnOp[2]);
        centerJanel.add(btn_x);

        centerJanel.add(btn_dot);
        centerJanel.add(btnDigit[0]);
        centerJanel.add(btn_zhengfu);
        centerJanel.add(btnOp[3]);
        centerJanel.add(btn_sqrt);
        centerJanel.add(btn_equal);
        this.add(centerJanel,BorderLayout.CENTER);

        /**
         * 底部布局
         */

        bottomJanel=new JPanel();
        btn_save=new JButton("保存");
        btn_copy=new JButton("复制");
        btn_clear=new JButton("清除");
        bottomJanel.add(btn_save);
        bottomJanel.add(btn_copy);
        bottomJanel.add(btn_clear);
        this.add(bottomJanel,BorderLayout.SOUTH);

    }
    private void initEvent() {
      HandleDigit handleDigit=new HandleDigit(this);
      for(int i=0;i<10;i++){
          btnDigit[i].addActionListener(handleDigit);
      }
      btn_back.addActionListener(new HandleBack(this));
      btn_c.addActionListener(new HandleClear(this));
      for(int i=0;i<4;i++){
          btnOp[i].addActionListener(new HandleOperator(this));
      }
      btn_dot.addActionListener(new HandleDot(this));
      btn_equal.addActionListener(new HandleEqual(this));
      btn_save.addActionListener(new HandleSave(this));
      btn_copy.addActionListener(new HandleCopy(this));
      btn_clear.addActionListener(new HandleClear(this));
      file_menu_item.addActionListener(new HandleSave(this));
    }
}
