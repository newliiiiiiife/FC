
/*
此类只要是实现 两个数字的运算,
*/

/**
*
* @author LULU
*/
public class computeNum {
	
	public computeNum()
	{
		
	}
   //以字符串形式传入 第一个数字  符号 第二个数组 ,根据符号运算,运算结果 以字符串形式返回
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
       }else if(fuhao.equals("×"))
       {
           sum=cheng(first,second);
       }else if(fuhao.equals("÷"))
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
   
  //加法
   private double jia(double x,double y)
   {
       double sum=x+y;
      // Math.exp(sum);
       return sum;
   }
   //减法
   private double jian(double x,double y)
   {
       double sum=x-y;
       return sum;
   }
   //乘法
   private double cheng(double x,double y)
   {
       double sum=x*y;
       return  sum;
   }
   //除法
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
   //取模
   private double mod(double x,double y)
   {
       long xx=(long)(x);
       long yy=(long)y;
       double sum=xx%yy;
       return sum;
   }

}


