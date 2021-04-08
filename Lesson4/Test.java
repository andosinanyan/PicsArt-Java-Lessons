class Test {
    public static void main(String[] args) {
        int[] array = {12,23,45,1,3,4};
	boolean isOkay = false; 
	
	while(!isOkay){
		isOkay = true;
	for(int i = 0; i <array.length - 1; i++){
		if(array[i] > array[i + 1]){
			int j = array[i];
			array[i] = array[i + 1];
			array[i + 1] = j;
			isOkay = false;
				}	
			}
		}
}
}
