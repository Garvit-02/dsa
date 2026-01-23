class Trappingwater{
    public static void trappedWater(int height[]){
        // Calculate Leftmax boundary in form of array
        int Leftmax[] = new int[height.length];

        Leftmax[0] = height[0];
        for(int i=1; i<height.length; i++){
            Leftmax[i] = Math.max(height[i], Leftmax[i-1]);
        }
        // Calculate Rightmax boundary in form of array
        int Rightmax[] = new int[height.length];

        Rightmax[height.length-1] = height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            Rightmax[i] =Math.max(height[i], Rightmax[i+1]);
        }
        //loop
        int trapped=0;
        for(int i=0; i<height.length; i++){
            //waterleavel = min(Leftmax boundary,Rightmax boundary)
            int waterleavel = Math.min(Leftmax[i], Rightmax[i]);

            //trapped water = min(Leftmax boundary,Rightmax boundary)-height
            trapped += (waterleavel-height[i]);
        }
        System.out.println(trapped);
    }
    public static void main(String[] args) {
        int height[]={4,2,0,6,3,2,5};
        trappedWater(height);
    }
}