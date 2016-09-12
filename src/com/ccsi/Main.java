package com.ccsi;

public class Main {

    public static void main(String[] args) {
	    int area=computeArea(-3,0,3,4,0,-1,9,2);
        System.out.println(area);
    }
    //Find the total area covered by two rectilinear rectangles in a 2D plane
    //Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
    public static int computeArea(int A,int B, int C,int D,int E,int F,int G,int H){
        int area1=getArea(A,B,C,D);
        int area2=getArea(E,F,G,H);
        int totalArea=area1+area2;
        if(isIntersected(A,B,C,D,E,F,G,H)){
            int intersectArea=(Math.min(C,G)-Math.max(A,E))*(Math.min(D,H)-Math.max(B,F)); //（小右-大左）*（小底-大顶）
            return totalArea-intersectArea;
        }else{
            return totalArea;
        }
    }
    public static int getArea(int left,int bottom, int right,int top){
        return Math.abs(right-left)*Math.abs(top-bottom);
    }
    public static boolean isIntersected(int A,int B, int C,int D,int E,int F,int G,int H){
        if(E>C) return false;
        if(G<A) return false;
        if(F>D) return false;
        if(H<B) return false;
        return true;
    }
}
