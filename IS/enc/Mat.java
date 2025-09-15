package enc;

import java.util.Random;
class Mat
{   int [][]a;
    Mat(){ a= new int [2][2];	}
    Mat(int n){ a= new int [n][n]; }
    void set()
    {  
        Random r = new Random(); 	
	    for(int i=0;i<a.length;i++)
	    for(int j=0;j<a[i].length;j++)
		a[i][j] = r.nextInt(10)+1;	
    }
    void disp()
    {  
        for(int i=0;i<a.length;i++){   
            for(int j=0;j<a[i].length;j++)
		        System.out.print(a[i][j]+"\t");
	        System.out.println();
        }
	    System.out.println();
    }

	Mat addMat(Mat m) {
		Mat t = new Mat(a.length);
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a[i].length; j++)
				t.a[i][j] = mod(a[i][j] + m.a[i][j]);
		return t;
	}

	Mat mulMat(Mat m) {
		Mat t = new Mat(a.length);	
	    for(int i=0;i<a.length;i++)
	        for(int j=0;j<a[i].length;j++)
		        for(int k=0;k<a.length;k++)
		            t.a[i][j]=mod(t.a[i][j]+a[i][k]*m.a[k][j]);
	    return t;
	}

	Mat scalarMul(int n) {
		Mat t = new Mat(a.length);
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a[i].length; j++)
				t.a[i][j] = mod(a[i][j] * n);
		return t;
	}
	
    int det()
    {	
        int d=0;
	    if(a.length==1) return a[0][0];
	        int sign = 1;
	    for(int i=0;i<a.length;i++)
	    {    
            d+=sign*a[0][i]*cofactor(0,i).det();
	        sign=-sign;
	    }
	    return d;
    }

    Mat cofactor(int r, int c)
    {	
        int n = a.length; 
		int row=0; int col=0;
		Mat t = new Mat(n-1);
		for(int i=0;i<n;i++)
	  	{   
            if(i==r) continue;
		    for(int j=0;j<n;j++)
		        if(j!=c)
			        t.a[row][col++] = a[i][j];
		    row++;col=0;
		}
		return t;
	}

	int mulInv(int n)
	{ 
        int a= n, b=26, q,r, t1=1,t2=0,t;
	    do
	    { 
            q=a/b;   r = a-q*b; 
	        a=b;  b=r;
	        t = t1-q*t2;
	        t1=t2; t2=t;
	    }while(r!=0);	
	    if(a==1) return mod(t1);
	    else return -1;
	}

	int mod(int n)
	{	   
        n = n%26; 
        n= (n+26)%26; 
        return n; 
    }
	
    Mat matMod()
	{	
        Mat t = new Mat(a.length);
		for(int i=0;i<a.length;i++)
	  	    for(int j=0;j<a.length;j++)
		        t.a[i][j] = mod(a[i][j]);
		return t;
	}

	Mat adj()
	{	
        Mat t = new Mat(a.length);
		for(int i=0;i<a.length;i++)
	  	    for(int j=0;j<a[i].length;j++)
                t.a[j][i] =(int)Math.pow(-1,i+j)*cofactor(i,j).det();
	    t= t.matMod();
	    return t;
	}

	Mat inv()
	{ 	
        int n = mulInv(det());
		if(n==-1) {
            System.out.println("No inverse");
			return new Mat(0); 
        } else {	
            Mat t = adj();
	  		for(int i=0;i<a.length;i++)
	  	        for(int j=0;j<a[i].length;j++)
			 	    t.a[i][j] = n*t.a[i][j];
			return t.matMod();
		}
	}
	Mat mul(Mat m)
	{  
        Mat t= new Mat(a.length);	
	    for(int i=0;i<a.length;i++)
	        for(int j=0;j<a[i].length;j++)
		        for(int k=0;k<a.length;k++)
		            t.a[i][j]+=a[i][k]*m.a[k][j];
	    return t.matMod();
	}

	Mat enc(Mat k)
	{	return mul(k).matMod();	}
	Mat dec(Mat k)
	{	return mul(k.inv()).matMod();	}
}
