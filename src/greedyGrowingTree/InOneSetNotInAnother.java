package greedyGrowingTree;

//ArrayList�����������
public class InOneSetNotInAnother {
	public boolean Judge(char ZrI, char[] Sr) {
		for (int i = 0; i < Sr.length; i++) {
			if (ZrI == Sr[i])
				return false;
		}
		return true;
	}
}
