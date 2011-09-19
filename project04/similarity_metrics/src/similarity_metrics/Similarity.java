package similarity_metrics;
import java.util.Random;

public class Similarity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[]a;
		double[]b;
		int i;
		Random gen = new Random(System.currentTimeMillis());
		a=new double[5];
		b=new double[5];
		for(i=0;i<5;i++){
			a[i]=gen.nextInt(5)+1;
			b[i]=gen.nextInt(5)+1;
		}
		System.out.println("Non Boolean Tests");
		System.out.println("Object 1:");		
		for(i=0;i<5;i++){
			System.out.println(a[i]);
		}
		System.out.println("Object 2:");		
		for(i=0;i<5;i++){
			System.out.println(b[i]);
		}
		System.out.println("Euclidean Result:");
		System.out.println(euclidean(a,b));
		System.out.println("Normalized Euclidean Result:");
		System.out.println(euclidean(a,b,1,5));
		System.out.println("Pearson Correlation Result:");
		System.out.println(pearson(a,b));
		System.out.println("Cosine Similarity Result:");
		System.out.println(cosine(a,b));

		for(i=0;i<5;i++){
			a[i]=gen.nextInt(2);
			b[i]=gen.nextInt(2);
		}
		System.out.println();
		System.out.println("Boolean Tests");
		System.out.println("Object 1:");		
		for(i=0;i<5;i++){
			System.out.println(a[i]);
		}
		System.out.println("Object 2:");		
		for(i=0;i<5;i++){
			System.out.println(b[i]);
		}
		System.out.println("SMC Result:");
		System.out.println(simpleMatching(a,b));
		System.out.println("Jaccard Result:");
		System.out.println(jaccard(a,b));
	}
	
	//non normalized euclidean distance
	//returns a double
	//negative one indicates incorrect sizing between a and b
	
	public static double euclidean(double[]a,double[]b){
		double ret=0;
		if(a.length==b.length){
			for(int i =0; i<a.length;i++){
				ret=ret+(a[i]-b[i])*(a[i]-b[i]);
			}
			ret=Math.sqrt(ret);
		}
		else{
			ret=-1;
		}
		return ret;
	}
	
	//normalized euclidean distance
	//returns a double between 0 and 1
	//negative one indicates incorrect sizing between a and b
	
	public static double euclidean(double[]a,double[]b,double[]min,double[]max){
		double ret=0;
		double maxval=0;
		if(a.length==b.length){
			for(int i =0; i<a.length;i++){
				ret=ret+(a[i]-b[i])*(a[i]-b[i]);
				maxval=maxval+(max[i]-min[i])*(max[i]-min[i]);
			}
			ret=Math.sqrt(ret);
			ret=ret/Math.sqrt(maxval);
		}
		else{
			ret=-1;
		}
		return ret;
	}
	
	//normalized euclidean distance
	//returns a double between 0 and 1
	//negative one indicates incorrect sizing between a and b
	
	public static double euclidean(double[]a,double[]b,double min, double max){

		double ret=0;
		double maxval=0;
		maxval=(max-min)*(max-min)*a.length;
		if(a.length==b.length){
			for(int i =0; i<a.length;i++){
				ret=ret+(a[i]-b[i])*(a[i]-b[i]);
			}
			ret=Math.sqrt(ret);
			ret=ret/Math.sqrt(maxval);
		}
		else{
			ret=-1;
		}
		return ret;	
	}
	
	//simple matching coefficient
	//returns a normalized double
	//negative one indicates different sized a,b
	
	
	public static double simpleMatching(double[]a,double[]b){
		double ret = 0;
		int i;
		if(a.length==b.length){
			for(i=0;i<a.length;i++){
				if(a[i]==b[i]){
					ret++;
				}
			}
			ret=ret/a.length;
		}
		else{
			ret=-1;
		}	
		return ret;
	}
	
	//Jaccard Similarity
	//returns a normalized double
	//negative one indicates different sized a,b

	public static double jaccard(double[]a,double[]b){
		double ret=0;
		double divisor=0;
		int i;
		if(a.length==b.length){
			for(i=0;i<a.length;i++){
				if(a[i]>0 || b[i]>0){
					if(a[i]>0 &&b[i]>0){
						ret++;
					}
					divisor++;
				}
			}
			ret=ret/divisor;
		}
		else{
			ret=-1;
		}
		return ret;
	}

	//Pearson Correlation
	//returns a normalized double
	//negative two indicates different sized a,b
	
	public static double pearson(double[]a,double[]b){
		double ret;
		double sum1=0,sum2=0,sum1sq=0,sum2sq=0,psum=0;
		double denominator;
		if(a.length==b.length){
			for(int i=0;i<a.length;i++){
				sum1=sum1+a[i];
				sum2=sum2+b[i];
				sum1sq=sum1sq+a[i]*a[i];
				sum2sq=sum2sq+b[i]*b[i];
				psum=psum+a[i]*b[i];
			}
			denominator=Math.sqrt((sum1sq-sum1*sum1/a.length)*(sum2sq-sum2*sum2/a.length));
			if(denominator==0){
				ret=0;
			}
			else{
				ret=(psum-sum1*sum2/a.length)/denominator;
			}
		}
		else{
			ret=-2;
		}
		
		return ret;
	}
	
	public static double cosine(double[]a,double[]b){
		double ret;
		double psum=0,sum1sq=0,sum2sq=0;
		if(a.length==b.length){
			for(int i=0;i<a.length;i++){
				sum1sq=sum1sq+a[i]*a[i];
				sum2sq=sum2sq+b[i]*b[i];
				psum=psum+a[i]*b[i];
			}
			ret=psum/(Math.sqrt(sum1sq)*Math.sqrt(sum2sq));
		}
		else{
			ret=-2;
		}
		return ret;
	}
	
}
