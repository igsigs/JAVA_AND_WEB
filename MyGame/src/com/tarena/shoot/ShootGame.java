package com.tarena.shoot;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

/** 主程序 */
public class ShootGame extends JPanel {
	public static final int WIDTH = 400; // 窗口宽
	public static final int HEIGHT = 654; // 窗口高

	public static BufferedImage background; // 背景图
	public static BufferedImage start; // 启动图
	public static BufferedImage pause; // 暂停图
	public static BufferedImage gameover; // 游戏结束图
	public static BufferedImage airplane; // 敌机图
	public static BufferedImage bee; // 小蜜蜂图
	public static BufferedImage bullet; // 子弹图
	public static BufferedImage hero0; // 英雄机图1
	public static BufferedImage hero1; // 英雄机图2

	public static final int START = 0; // 启动状态
	public static final int RUNNING = 1; // 运行状态
	public static final int PAUSE = 2; // 暂停状态
	public static final int GAME_OVER = 3; // 游戏结束状态
	private int state = 0; // 当前状态

	private Hero hero = new Hero(); // 英雄机对象
	private FlyingObject[] flyings = {}; // 敌人(敌机+小蜜蜂)数组
	private Bullet[] bullets = {}; // 子弹数组
	private Timer timer; // 定时器
	private int intervel = 10; // 时间间隔(以毫秒为单位)

	static { // 初始化静态资源
		try {
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 随机生成敌人(敌机+小蜜蜂)对象 */
	public static FlyingObject nextOne() {
		Random rand = new Random(); // 随机数对象
		int type = rand.nextInt(20); // 生成0到19之间的随机数
		if (type == 0) {
			return new Bee(); // 为0时返回蜜蜂对象
		} else {
			return new Airplane(); // 1到19时返回敌机对象
		}
	}

	int flyEnteredIndex = 0; // 敌人入场计数

	/** 敌人入场 */
	public void enterAction() { // 10毫秒走一次
		flyEnteredIndex++; // 10毫秒增1
		if (flyEnteredIndex % 40 == 0) { // 每400(10*40)毫秒走一次
			FlyingObject one = nextOne(); // 获取随机敌人对象
			flyings = (FlyingObject[]) Arrays.copyOf(flyings,
					flyings.length + 1); // 扩容
			flyings[flyings.length - 1] = one; // 将敌人存储到flyings数组中的最后一个元素
		}
	}

	/** 飞行物走一步 */
	public void stepAction() { // 10毫秒走一次
		hero.step(); // 英雄机走一步
		for (int i = 0; i < flyings.length; i++) { // 遍历所有敌人(敌机+小蜜蜂)
			flyings[i].step(); // 敌人走一步
		}
		for (int i = 0; i < bullets.length; i++) { // 遍历所有子弹
			bullets[i].step(); // 子弹走一步
		}
	}

	int shootIndex = 0; // 英雄机发射子弹计数器

	/** 子弹入场(英雄机发射子了弹) */
	public void shootAction() { // 10毫秒走一次
		shootIndex++; // 10毫秒增1
		if (shootIndex % 30 == 0) { // 每300(10*30)毫秒走一次
			Bullet[] bs = hero.shoot(); // 获取英雄机发射的子弹数组
			bullets = (Bullet[]) Arrays.copyOf(bullets, bullets.length
					+ bs.length); // 扩容(bs有几个扩充几个)
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length,
					bs.length); // 追加数组
		}
	}

	/** 所有子弹与所有敌人碰撞 */
	public void bangAction() { // 10毫秒走一次
		for (int i = 0; i < bullets.length; i++) {
			bang(bullets[i]); // 一个子弹与所有敌人撞
		}
	}

	private int score = 0; // 得分

	/** 一个子弹与所有敌人碰撞 */
	public void bang(Bullet bullet) {
		int index = -1; // 被撞的敌人索引
		for (int i = 0; i < flyings.length; i++) { // 遍历所有敌人
			FlyingObject f = flyings[i]; // 获取每一个敌人
			if (f.shootBy(bullet)) { // 撞上了
				index = i; // 记录将被撞敌人索引
				break;
			}
		}
		if (index != -1) { // 撞上了
			FlyingObject one = flyings[index]; // 获取被撞的敌人对象
			if (one instanceof Enemy) { // 是敌人
				Enemy e = (Enemy) one; // 将被撞敌人强转为Enemy类型
				score += e.getScore(); // 得分
			}
			if (one instanceof Award) { // 是奖励
				Award a = (Award) one; // 将被撞敌人强转为Award类型
				int type = a.getType(); // 获取奖励类型
				switch (type) { // 根据奖励类型获取不同奖励
				case Award.DOUBLE_FIRE: // 若奖励类型为火力值
					hero.addDoubleFire(); // 英雄机增火力
					break;
				case Award.LIFE: // 若奖励类型为命
					hero.addLife(); // 英雄机增命
					break;
				}
			}
			// 将被撞敌人与最后一个元素交换
			FlyingObject f = flyings[index];
			flyings[index] = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = f;
			// 缩容(删除最后一个元素，即被撞的敌人)
			flyings = (FlyingObject[]) Arrays.copyOf(flyings,
					flyings.length - 1);
		}
	}

	/** 删除越界的飞行物 */
	public void outOfBoundsAction() {
		int index = 0; // 1.不越界敌人数组索引 2.不越界敌人个数
		FlyingObject[] flyingLives = new FlyingObject[flyings.length]; // 不越界敌人数组
		for (int i = 0; i < flyings.length; i++) { // 遍历所有敌人
			FlyingObject f = flyings[i]; // 获取每一个敌人
			if (!f.outOfBounds()) { // 不越界
				flyingLives[index++] = f; // 将不越界敌人添加到不越界敌人数组中，同时，不越界敌人个数增1
			}
		}
		flyings = (FlyingObject[]) Arrays.copyOf(flyingLives, index); // 将不越界敌人数组复制到flyings，flyings数组长度为index

		index = 0; // 索引/计数器归零
		Bullet[] bulletLives = new Bullet[bullets.length]; // 不越界子弹数组
		for (int i = 0; i < bullets.length; i++) { // 遍历所有子弹
			Bullet b = bullets[i]; // 获取每一个子弹
			if (!b.outOfBounds()) { // 不越界
				bulletLives[index++] = b; // 将不越界子弹添加到不越界子弹数组中，同时，不越界子弹个数增1
			}
		}
		bullets = (Bullet[]) Arrays.copyOf(bulletLives, index); // 将不越界子弹数组复制到bullets，bullets数组长度为index
	}

	/** 检查游戏是否结束 */
	public void checkGameOverAction() { // 10毫秒
		if (isGameOver()) { // 游戏结束时
			state = GAME_OVER; // 设置当前状态为游戏结束状态
		}
	}

	/** 判断游戏是否结束 返回true表示游戏结束 */
	public boolean isGameOver() {
		for (int i = 0; i < flyings.length; i++) { // 遍历所有敌人
			FlyingObject f = flyings[i]; // 获取每一个敌人
			if (hero.hit(f)) { // 撞上了
				hero.subtractLife(); // 英雄机减命
				hero.setDoubleFire(0); // 英雄机火力值清零

				// 交换被撞敌人与最后一个元素
				FlyingObject t = flyings[i];
				flyings[i] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = t;
				// 缩容(删除最后一个元素，即被撞的敌人对象)
				flyings = (FlyingObject[]) Arrays.copyOf(flyings,
						flyings.length - 1);
			}
		}

		return hero.getLife() <= 0; // 英雄机命数小于或等于0时游戏结束
	}

	/** 启动执行 */
	public void action() {
		// 创建侦听器对象
		MouseAdapter l = new MouseAdapter() {
			/** 鼠标移动事件处理 */
			public void mouseMoved(MouseEvent e) {
				if (state == RUNNING) { // 运行时
					int x = e.getX(); // 获取鼠标的x坐标
					int y = e.getY(); // 获取鼠标的y坐标
					hero.moveTo(x, y); // 英雄机随着鼠标动
				}
			}

			/** 鼠标点击事件处理 */
			public void mouseClicked(MouseEvent e) {
				switch (state) {
				case START: // 启动状态时
					state = RUNNING; // 改为运行状态
					break;
				case GAME_OVER: // 游戏结束状态时
					score = 0; // 清理现场
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START; // 改为启动状态
					break;
				}
			}

			/** 鼠标移开事件处理 */
			public void mouseExited(MouseEvent e) {
				if (state == RUNNING) { // 运行状态时
					state = PAUSE; // 改为暂停状态
				}
			}

			/** 鼠标移入事件处理 */
			public void mouseEntered(MouseEvent e) {
				if (state == PAUSE) { // 暂停状态时
					state = RUNNING; // 改为运行状态
				}
			}
		};
		this.addMouseListener(l); // 处理鼠标操作事件
		this.addMouseMotionListener(l); // 处理鼠标滑动事件

		timer = new Timer(); // 创建定时器对象
		timer.schedule(new TimerTask() {
			public void run() { // 定时干的事，10毫秒走一次
				if (state == RUNNING) { // 运行状态时
					enterAction(); // 敌人(敌机+小蜜蜂)入场
					stepAction(); // 飞行物走一步
					shootAction(); // 子弹入场(英雄机发射子弹)
					bangAction(); // 子弹与敌人碰撞
					outOfBoundsAction(); // 删除越界的飞行物
					checkGameOverAction(); // 检查游戏是否结束
				}
				repaint(); // 重绘(调用paint()方法)
			}
		}, intervel, intervel);
	}

	/** 重写paint() g:画笔 */
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null); // 画背景图
		paintHero(g); // 画英雄机对象
		paintFlyingObjects(g); // 画敌人(敌机+小蜜蜂)对象
		paintBullets(g); // 画子弹对象
		paintScore(g); // 画分和画命
		paintState(g); // 画状态
	}

	/** 画英雄机 */
	public void paintHero(Graphics g) {
		g.drawImage(hero.image, hero.x, hero.y, null); // 画英雄机对象
	}

	/** 画敌人 */
	public void paintFlyingObjects(Graphics g) {
		for (int i = 0; i < flyings.length; i++) { // 遍历所有敌人
			FlyingObject f = flyings[i]; // 获取每一个敌人
			g.drawImage(f.image, f.x, f.y, null); // 画敌人对象
		}
	}

	/** 画子弹 */
	public void paintBullets(Graphics g) {
		for (int i = 0; i < bullets.length; i++) { // 遍历所有子弹
			Bullet b = bullets[i]; // 获取每一个子弹
			g.drawImage(b.image, b.x, b.y, null); // 画子弹对象
		}
	}

	/** 画分和画命 */
	public void paintScore(Graphics g) {
		g.setColor(new Color(0xFF0000)); // 设置颜色为红色
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20)); // 设置样式(SANS_SERIF:字体
		// BOLD:字体样式加粗
		// 20:字号)
		g.drawString("SCORE: " + score, 10, 25); // 画分
		g.drawString("LIFE: " + hero.getLife(), 10, 45); // 画命
	}

	/** 画状态 */
	public void paintState(Graphics g) {
		switch (state) {
		case START:
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER:
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}

	/** 主方法 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Flyllll"); // 窗口
		ShootGame game = new ShootGame(); // 面板
		frame.add(game); // 将面板添加到窗口中
		frame.setSize(WIDTH, HEIGHT); // 设置窗口大小
		frame.setAlwaysOnTop(true); // 设置一直居上
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置默认关闭操作--关闭窗口时退出程序
		frame.setLocationRelativeTo(null); // 设置相对位置为null，即:居中
		frame.setVisible(true); // 1.设置窗口可见 2.尽快调用paint()方法

		game.action(); // 启动执行

	}
}
