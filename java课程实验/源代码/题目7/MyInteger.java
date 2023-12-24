public class MyInteger {
 private int value;
public void MyInteger(){
 
}
public void MyInteger(int q){
 this.value=q;
}
public boolean isEven(){
 if(this.value%2==0)
  return true;
 else
  return false;
}
public boolean isOdd(){
 if(this.value%2!=0)
  return true;
 else
  return false;
}
public boolean isPrime(){
 int i;
  for(i=2;i<=this.value;i++)
  {
   if(this.value%i==0)
   {
    break;
   } 
  }
  if(i==this.value)
   return true;
  else 
   return false; 
}
public boolean isEven(int a){
 if(a%2==0)
  return true;
 else
  return false;
}
public boolean isOdd(int b){
 if(b%2!=0)
  return true;
 else
  return false;
}
public boolean isPrime(int c){
 int i;
  for(i=2;i<=c;i++)
  {
   if(c%i==0)
   {
    break;
   } 
  }
  if(i==c)
   return true;
  else 
   return false; 
}
public boolean equals(int d){
 if(this.value==d)
  return true;
 else
  return false;
}
public int getValue() {
 return this.value;
}
public static boolean isEven(MyInteger c1){
 if(c1.getValue()%2==0)
  return true;
 else
  return false;
}
public static boolean isOdd(MyInteger c1){
 if(c1.getValue()%2!=0)
  return true;
 else
  return false;
}
public static boolean isPrime(MyInteger c1){
 int i;
  for(i=2;i<=c1.getValue();i++)
  {
   if(c1.getValue()%i==0)
   {
    break;
   } 
  }
  if(i==c1.getValue())
   return true;
  else 
   return false; 
}
public  boolean equals(MyInteger c1){
 if(this.value==c1.value)
  return true;
 else
  return false;
}
}