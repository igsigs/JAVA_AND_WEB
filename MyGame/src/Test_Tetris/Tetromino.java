package Test_Tetris;

import java.util.Arrays;
import java.util.Random;

/**
 * 4格方块
 * 
 * @author Administrator
 *
 */
public abstract class Tetromino {
	protected Cell[] cells = new Cell[4]; // cells 属性用来存放四个格子，既一个方块

	public static Tetromino randomOne() { // 随机产生4格方块
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

	public void softDrop() { // 方块下落一个格子
		for (int i = 0; i < cells.length; i++) {
			cells[i].drop();
		}
	}

	public void moveLeft() { // 方块左移一个格子
		for (int i = 0; i < cells.length; i++) {
			cells[i].moveLeft();
		}
	}

	public void moveRight() { // 方块右移一个格子
		for (int i = 0; i < cells.length; i++) {
			cells[i].moveRight();
		}
	}

	public String toString() { // 覆盖toString 方法，显示方块中每个格子的行列信息
		return Arrays.toString(cells);
	}
}

class T extends Tetromino { // T 形方块
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