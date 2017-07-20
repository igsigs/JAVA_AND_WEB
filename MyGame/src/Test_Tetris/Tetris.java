package Test_Tetris;

/**
 * 用于构建尔罗斯方块项目的整体流程
 * 
 * @author Administrator
 *
 */
public class Tetris {
	private int score; // 分数
	private int lines; // 销毁的行数
	private Cell[][] wall; // 背景墙
	private Tetromino tetromino; // 正在下落的四格方块
	private Tetromino nextOne; // 下一个四格方块

	public static final int ROWS = 20; // 背景墙的行数
	public static final int COLS = 10; // 背景墙的列数

	public static void main(String[] args) {

	}
}
