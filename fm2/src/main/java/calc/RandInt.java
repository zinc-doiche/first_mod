package calc;
public class RandInt {

	public RandInt() {}
	
	public int randomInt(int min, int max) {
		return (int) (Math.random()*(max-min+1)+min);
	}
}
