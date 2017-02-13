package yuskie.turnBasedGames.ChessV2;

import java.util.Arrays;

public class Utility {

	public static final String[] XVALUES = new String[] { "a", "b", "c", "d", "e", "f", "g", "h" };

	public static enum Color {
		BLACK, WHITE
	}
	
	public static boolean straightMovement(String startLoc, String endLoc, int distance){
		int getXStartLoc = getXValue(startLoc);
		int getYStartLoc = getYValue(startLoc);
		
		int getXEndLoc = getXValue(endLoc);
		int getYEndLoc = getYValue(endLoc);
		
		if(getXStartLoc == -1 || getYStartLoc == -1 || getXEndLoc == -1 || getYEndLoc == -1){
			return false;
		}
		
		//If start and end don't have a similar x or y value, it is not moving straight
		if(getXStartLoc != getXEndLoc && getYStartLoc != getYEndLoc){
			return false;
		}
		if(Math.abs(getXStartLoc-getXEndLoc)>distance || Math.abs(getYStartLoc-getYEndLoc)>distance){
			return false;
		}
		return true;
	}
	
	public static boolean diagonalMovement(String startLoc, String endLoc, int distance){
		int getXStartLoc = getXValue(startLoc);
		int getYStartLoc = getYValue(startLoc);
		
		int getXEndLoc = getXValue(endLoc);
		int getYEndLoc = getYValue(endLoc);
		
		if(getXStartLoc == -1 || getYStartLoc == -1 || getXEndLoc == -1 || getYEndLoc == -1){
			return false;
		}
		
		if(getXStartLoc == getXEndLoc || getYStartLoc == getYEndLoc){
			return false;
		}
		if(Math.abs(getXStartLoc-getXEndLoc)>distance || Math.abs(getYStartLoc-getYEndLoc)>distance){
			return false;
		}
		if(Math.abs(getXStartLoc-getXEndLoc) == Math.abs(getYStartLoc-getYEndLoc)){
			return true;
		}
		return false;
	}
	
	public static boolean lMovement(String startLoc, String endLoc){
		int getXStartLoc = getXValue(startLoc);
		int getYStartLoc = getYValue(startLoc);
		
		int getXEndLoc = getXValue(endLoc);
		int getYEndLoc = getYValue(endLoc);
		
		if(getXStartLoc == -1 || getYStartLoc == -1 || getXEndLoc == -1 || getYEndLoc == -1){
			return false;
		}
		
		if(getXStartLoc == getXEndLoc || getYStartLoc == getYEndLoc){
			return false;
		}
		
		if((Math.abs(getXStartLoc - getXEndLoc) == 2 && Math.abs(getYStartLoc-getYEndLoc) ==1) ||
				(Math.abs(getXStartLoc - getXEndLoc) == 1 && Math.abs(getYStartLoc-getYEndLoc) ==2)){
			return true;
		}
		
		return false;
	}
	
	public static String getNextLoc(String startLoc, String endLoc){
		int getXStartLoc = getXValue(startLoc);
		int getYStartLoc = getYValue(startLoc);
		
		int getXEndLoc = getXValue(endLoc);
		int getYEndLoc = getYValue(endLoc);
		
		// Knight movement
		if((Math.abs(getXStartLoc - getXEndLoc) == 2 && Math.abs(getYStartLoc-getYEndLoc) ==1) ||
				(Math.abs(getXStartLoc - getXEndLoc) == 1 && Math.abs(getYStartLoc-getYEndLoc) ==2)){
			return endLoc;
		}
		//Diagonal movement
		if(Math.abs(getXStartLoc-getXEndLoc) == Math.abs(getYStartLoc-getYEndLoc)){
			if(getXStartLoc-getXEndLoc<0){
				getXStartLoc--;
			}else{
				getXStartLoc++;
			}
			if(getYStartLoc-getYEndLoc<0){
				getYStartLoc--;
			}else{
				getYStartLoc++;
			}
			return convertIntToString(getXStartLoc, getYStartLoc);
		}
		//Default movement (Straight movement)
		if(getXStartLoc-getXEndLoc<0){
			getXStartLoc--;
		}else if(getXStartLoc-getXEndLoc>0){
			getXStartLoc++;
		}
		if(getYStartLoc-getYEndLoc<0){
			getYStartLoc--;
		}else if(getYStartLoc-getYEndLoc>0){
			getYStartLoc++;
		}
		return convertIntToString(getXStartLoc, getYStartLoc);
	}
	
	// Remember to handle index out of bound when called
	private static int getXValue(String loc) {
		String xValueString = loc.substring(0, 1);
		try {
			int xLoc = Arrays.asList(Utility.XVALUES).indexOf(xValueString);
			return xLoc;
		} catch (Exception e) {
			return -1;
		}
	}

	// Remember to handle out of range
	private static int getYValue(String loc) {
		try {
			String yValueString = loc.substring(1);
			int yLoc = Integer.parseInt(yValueString);
			if (yLoc > 8) {
				return -1;
			}
			return yLoc;
		} catch (Exception e) {
			return -1;
		}
	}
	
	private static String convertIntToString(int x, int y){
		return XVALUES[x] + y;
	}
}
