
/*
����ֻҪ��ʵ�� �������ֵ�����,
*/

/**
*
* @author LULU
*/
public class computeNum {
	
	public computeNum()
	{
		
	}
   //���ַ�����ʽ���� ��һ������  ���� �ڶ������� ,���ݷ�������,������ ���ַ�����ʽ����
   public String cmpNum(String f,String fuhao,String s)
   {
       if(fuhao.equals(""))
       {
           return s;
       }
       String str="";
       Double first=Double.valueOf(f);
       Double second=Double.valueOf(s);
       Double sum=0.0;
       if(fuhao.equals("+"))
       {
           sum=jia(first,second);
       }else if(fuhao.equals("-"))
       {
           sum=jian(first,second);
       }else if(fuhao.equals("��"))
       {
           sum=cheng(first,second);
       }else if(fuhao.equals("��"))
       {
           sum=chu(first,second);
       }else if(fuhao.equals("^"))
       {
           sum=pow(first,second);
       }else if(fuhao.equals("%"))
       {
           sum=mod(first,second);
       }
       
       str=String.valueOf(sum);
       return str;
   }
   
  //�ӷ�
   private double jia(double x,double y)
   {
       double sum=x+y;
      // Math.exp(sum);
       return sum;
   }
   //����
   private double jian(double x,double y)
   {
       double sum=x-y;
       return sum;
   }
   //�˷�
   private double cheng(double x,double y)
   {
       double sum=x*y;
       return  sum;
   }
   //����
   private double chu(double x,double y)
   {
       double sum=x/y;
       return sum;
   }

   private double pow(double x,double y)
   {
       double sum=Math.pow(x, y);
       return sum;
   }
   //ȡģ
   private double mod(double x,double y)
   {
       long xx=(long)(x);
       long yy=(long)y;
       double sum=xx%yy;
       return sum;
   }

}


