#include<stdio.h>
#include<math.h>

//GCD 
int gcd(long long int a,long long int b)
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
long long int c,m, p=7,q=11,e=2,d=1, n=p*q, phi=(p-1)*(q-1);
while(e<phi)
{
if(gcd(e,phi)==1)
break;
else
e++;
}
while(d<phi)
{
if((e*d)%phi==1)
break;
else
d++;
}

printf("p and q and phi are %lli \t%lli\t%lli respectively\nPublic and Private keys are %lli\t%lli\n",p,q,phi,e,d);

printf("\nEnter your msg\t");
scanf("%lld",&m);
m=pow(m,e);
c=fmod(m,n);
printf("\ncipher is %lld\n",c);
m=pow(c,d);
m=fmod(m,n);
printf("\nDecipher is %lld\n",m);
}
