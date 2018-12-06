public int solution (int n){
	String binRep = Integer.toBinaryString(n);
	int i = 0;
	int maxGap = 0;
	int curGap = 0;
	
	while(i < binRep.length()-1){
		if(binRep.charAt(i) == '1'){
			i++;//skip 1 bit
			while(binRep.charAt(i)=='0' && i < binRep.length()-1){
				curGap++;
				i++;
			}
			if(maxGap<curGap && binRep.charAt(i)=='1'){
				//second if to handle case 10000000
				maxGap = curGap;
			}
			curGap = 0;
		}
	}
	return maxGap;
}