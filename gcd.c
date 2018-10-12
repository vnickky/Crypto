#include<stdio.h>
#include<math.h>

int gcd(int a,int b)
{
if(a==0)
return b;
else if(b==0)
return a;
else if(a==1||b==1)
return 1;
else 
{
if(a>b)
gcd(a%b,b);
else
return
gcd(a,b%a);
}
}

void main()
{
int num1,num2,g;
printf("\nEnter first number\t");
scanf("%d",&num1);
printf("\nEnter second number\t");
scanf("%d",&num2);
printf("\n\nGCD of both numbers are %d\n\n",gcd(num1,num2));
}
