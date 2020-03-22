

/*
此类用以生成一个计算机，主要是生成计算器的界面，并侦听点击哪个按钮，其运算主要是在类ComputerNum里
*/

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
*
* @author LULU
*/
public class CmpCounter implements ActionListener
{
   //根据下列数组声称的按钮数组
   private JButton[] btnArr;
   //按钮顺序
   private String[] str={"7","8","9","÷","4","5","6","×","1","2","3","+","0","^","%","-",".","=","复位"};
   //顶部文本
   private JTextField topTxt;
   //下部文本
   private JTextField leftTxt;
   //框架
   private JFrame f;
   //运算对象，求输入的数字的运算结果
   private computeNum cmpObj;
   //输入的第一个数字.
   private String preNum="0";
   //输入的运算符
   private String preChar="";
   //是否点了运算符
   private Boolean cmpBl=false;

   public CmpCounter()
   {
       //初始化框架
       int len=str.length;
       btnArr=new JButton[len];
       cmpObj=new computeNum();
       setFrame();
   }
   //生成计算器框架,及两个文本显示框和数字按钮
   private void setFrame()
   {
       f = new JFrame("计算器");
	   f.setSize(200,240);
	   f.setLocation(300,200);
	   f.setResizable(false);
	   f.setVisible(true);
       f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       f.setLayout(null);

       topTxt=setTxt(0,0,190,20);
       topTxt.setHorizontalAlignment(JTextField.RIGHT);
       f.add(topTxt);
       leftTxt=setTxt(0,20,190,20);
       leftTxt.setHorizontalAlignment(JTextField.RIGHT);
       leftTxt.setText("0");
       topTxt.setText("0");
       f.add(leftTxt);
       leftTxt.setEditable(false);
       topTxt.setEditable(false);
       leftTxt.validate();
       topTxt.validate();
       
       f.validate();
       setBtn();
   }
   //排布计算器中的按钮显示
   private void setBtn()
   {
       //按钮显示容器
       JPanel panel=new JPanel();
       FlowLayout flow=new FlowLayout();
       flow.setAlignment(FlowLayout.LEFT);
       panel.setAlignmentX(0);

       panel.setLayout(flow);
       panel.setVisible(true);
       panel.setSize(200,170);
       panel.setLocation(0, 40);
       f.add(panel);
       //初始化按钮,并给按钮添加侦听
       for(int i=0;i<str.length;i++)
       {
          JButton btn=new JButton(str[i]);
           btn.setSize(50,38);
           btn.setVisible(true);
           btn.addActionListener(this);
           btnArr[i]=btn;
           panel.add(btn);
       }
       panel.validate();
   }
   //点击按钮时做出的响应
   public void actionPerformed(ActionEvent e)
   {
	   if(e==null)
	   {
		   return;
	   }
       Object obj=e.getSource();
       //点击的是第几个按钮
       int i=indexOf(obj);
       int kind=0;//1 表示点击的是数组,二表示点击的是符号 3表示等号
       String clicked="";
       if(i>-1)
       {
           switch(i)
           {
               case 0://7
                   clicked="7";
                   kind=1;
                   break;
               case 1://8
                   clicked="8";
                   kind=1;
                   break;
               case 2://9
                   clicked="9";
                   kind=1;
                   break;
               case 3://÷
                   clicked="÷";
                   kind=2;
                   break;
               case 4://4
                   clicked="4";
                   kind=1;
                   break;
               case 5://5
                   clicked="5";
                   kind=1;
                   break;
               case 6://6
                   clicked="6";
                   kind=1;
                   break;
               case 7://×
                   clicked="×";
                   kind=2;
                   break;
               case 8://1
                   clicked="1";
                   kind=1;
                   break;
               case 9://2
                   clicked="2";
                   kind=1;
                   break;
               case 10://3
                   clicked="3";
                   kind=1;
                   break;
               case 11://+
                   clicked="+";
                   kind=2;
                   break;
               case 12://0
                   clicked="0";
                   kind=1;
                   break;
               case 13://^
                   clicked="^";
                   kind=2;
                   break;
               case 14:///
                   clicked="%";
                   kind=2;
                   break;
               case 15://-
                   kind=2;
                   clicked="-";
                   break;
               case 16://.
                   kind=1;
                   clicked=".";
                   break;
               case 17://=
                   kind=3;
                   clicked="=";
                   break;

               case 18://恢复
                   clearWindow();
                   return;
               case 19://删除
                   return;
           }
           String leftStr=leftTxt.getText();
           if(leftStr.equals("0"))
           {
               leftStr="";
           }
           //点击的是数字还是符号
           switch(kind)
           {
               case 1:
                   
                   if(cmpBl.equals(true))
                   {
                       leftStr="";
                       cmpBl=false;
                   }
                   if(leftStr.length()>=12)
                   {
                       return;
                   }
                   leftStr+=clicked;
                   leftTxt.setText(leftStr);
                   break;
               case 2:
                  clickChar(clicked);
                   break;
               case 3:
                   clickChar(clicked);
                   preChar="";
                   cmpBl=false;
                   preNum=leftTxt.getText();
                   topTxt.setText("0");
                   break;
           }

       }
   }

   //当 点击的是字符时应该做出的响应
   private void clickChar(String clicked)
   {
       String leftStr=leftTxt.getText();
       
       if(cmpBl==true)
       {
           return;
       }
       String topStr=topTxt.getText();
       if(topStr.equals("0"))
       {
           topStr="";
       }
       topStr+=(leftStr+clicked);
       
       topTxt.setText(topStr);
       preNum=cmpObj.cmpNum(preNum,preChar,leftTxt.getText());
       preChar=clicked;
       leftTxt.setText(preNum);
       cmpBl=true;
   }
   //遍历数组 查询点击的是第几个按钮
   private int indexOf(Object obj)
   {
       int pos=-1;
       for(int i=0;i<btnArr.length;i++)
       {
           if(btnArr[i]==obj)
               return i;
       }
       return pos;
   }
   //文本设置函数
   private JTextField setTxt(int x,int y,int w,int h)
   {
       JTextField txt=new JTextField();
       txt.setSize(w, h);
       txt.setBounds(x, y, w, h);
       txt.setVisible(true);
       txt.setText("0");
       return txt;
   }
   //当点击清空时刷新整个窗口
   private void clearWindow()
   {
      preNum="0";
      preChar="";
      cmpBl=false;
      topTxt.setText("0");
      leftTxt.setText("0");
   }
}

