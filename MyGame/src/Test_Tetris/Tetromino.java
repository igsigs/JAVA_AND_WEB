package Test_Tetris;

import java.util.Arrays;
import java.util.Random;

/**
 * 4�񷽿�
 * 
 * @author Administrator
 *
 */
public abstract class Tetromino {
	protected Cell[] cells = new Cell[4]; // cells ������������ĸ����ӣ���һ������

	public static Tetromino randomOne() { // �������4�񷽿�
		Random random = new Random();
		int type = random.nextInt(7);
		switch (type) {
		case 0:
			return new T();
		case 1:
			return new I();
		case 2:
			return new S();
		case 3:
			return new J();
		case 4:
			return new L();
		case 5:
			return new Z();
		case 6:
			return new O();
		}
		return null;
	}

	public void softDrop() { // ��������һ������
		for (int i = 0; i < cells.length; i++) {
			cells[i].drop();
		}
	}

	public void moveLeft() { // ��������һ������
		for (int i = 0; i < cells.length; i++) {
			cells[i].moveLeft();
		}
	}

	public void moveRight() { // ��������һ������
		for (int i = 0; i < cells.length; i++) {
			cells[i].moveRight();
		}
	}

	public String toString() { // ����toString ��������ʾ������ÿ�����ӵ�������Ϣ
		return Arrays.toString(cells);
	}
}

class T extends Tetromino { // T �η���
	public T() {
		cells[0] = new Cell(0, 4, null);
		cells[1] = new Cell(0, 3, null);
		cells[2] = new Cell(0, 2, null);
		cells[3] = new Cell(0, 1, null);
	}
}

class I extends Tetromino {

}

class S extends Tetromino {

}

class Z extends Tetromino {

}

class O extends Tetromino {

}

class L extends Tetromino {

}

class J extends Tetromino {

}