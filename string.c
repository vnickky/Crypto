#include <stdio.h>
#include <stdlib.h>
#include<time.h>
#include<unistd.h>

//Primechecker

int primechecker(int n)
{
for(int i=2;i<n;i=i)
{
if(n%i==0)
{
return -1;
break;
}
else
i++;
}
}

//Random Prime

int randomPrime(int n)
{
if(primechecker(n)!=-1)
{
return n;
}
else
{
n++;
randomPrime(n);
}

}

//Main Function

void main()
{
int p,q;
srand(time(0));
p=rand();
p=randomPrime(p%16);
sleep(1);
q=rand();
q=randomPrime(q%16); 
printf("\nRandomly generated Primes p and q are %d\t%d \n",p,q);
}
