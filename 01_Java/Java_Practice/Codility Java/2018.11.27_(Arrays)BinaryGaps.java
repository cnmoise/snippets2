public int solution (int n){
	String binRep = Integer.toBinaryString(n);
	// int i = 0;
	int maxGap = 0;
	int curGap = 0;
	
	for(int i = 0; i < binRep.length()-1; i++){
		if(binRep.charAt(i) == '1'){
			i++;//skip 1 bit
			while(binRep.charAt(i)=='0'){
				curGap++;
				i++;
			}
			if(maxGap<curGap){
				maxGap = curGap;
			}
			curGap = 0;
		}
	}
	return maxGap;
}