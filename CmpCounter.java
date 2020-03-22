

/*
������������һ�����������Ҫ�����ɼ������Ľ��棬����������ĸ���ť����������Ҫ������ComputerNum��
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
   //���������������Ƶİ�ť����
   private JButton[] btnArr;
   //��ť˳��
   private String[] str={"7","8","9","��","4","5","6","��","1","2","3","+","0","^","%","-",".","=","��λ"};
   //�����ı�
   private JTextField topTxt;
   //�²��ı�
   private JTextField leftTxt;
   //���
   private JFrame f;
   //�����������������ֵ�������
   private computeNum cmpObj;
   //����ĵ�һ������.
   private String preNum="0";
   //����������
   private String preChar="";
   //�Ƿ���������
   private Boolean cmpBl=false;

   public CmpCounter()
   {
       //��ʼ�����
       int len=str.length;
       btnArr=new JButton[len];
       cmpObj=new computeNum();
       setFrame();
   }
   //���ɼ��������,�������ı���ʾ������ְ�ť
   private void setFrame()
   {
       f = new JFrame("������");
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
   //�Ų��������еİ�ť��ʾ
   private void setBtn()
   {
       //��ť��ʾ����
       JPanel panel=new JPanel();
       FlowLayout flow=new FlowLayout();
       flow.setAlignment(FlowLayout.LEFT);
       panel.setAlignmentX(0);

       panel.setLayout(flow);
       panel.setVisible(true);
       panel.setSize(200,170);
       panel.setLocation(0, 40);
       f.add(panel);
       //��ʼ����ť,������ť�������
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
   //�����ťʱ��������Ӧ
   public void actionPerformed(ActionEvent e)
   {
	   if(e==null)
	   {
		   return;
	   }
       Object obj=e.getSource();
       //������ǵڼ�����ť
       int i=indexOf(obj);
       int kind=0;//1 ��ʾ�����������,����ʾ������Ƿ��� 3��ʾ�Ⱥ�
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
               case 3://��
                   clicked="��";
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
               case 7://��
                   clicked="��";
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

               case 18://�ָ�
                   clearWindow();
                   return;
               case 19://ɾ��
                   return;
           }
           String leftStr=leftTxt.getText();
           if(leftStr.equals("0"))
           {
               leftStr="";
           }
           //����������ֻ��Ƿ���
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

   //�� ��������ַ�ʱӦ����������Ӧ
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
   //�������� ��ѯ������ǵڼ�����ť
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
   //�ı����ú���
   private JTextField setTxt(int x,int y,int w,int h)
   {
       JTextField txt=new JTextField();
       txt.setSize(w, h);
       txt.setBounds(x, y, w, h);
       txt.setVisible(true);
       txt.setText("0");
       return txt;
   }
   //��������ʱˢ����������
   private void clearWindow()
   {
      preNum="0";
      preChar="";
      cmpBl=false;
      topTxt.setText("0");
      leftTxt.setText("0");
   }
}

