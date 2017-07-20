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

/** ������ */
public class ShootGame extends JPanel {
	public static final int WIDTH = 400; // ���ڿ�
	public static final int HEIGHT = 654; // ���ڸ�

	public static BufferedImage background; // ����ͼ
	public static BufferedImage start; // ����ͼ
	public static BufferedImage pause; // ��ͣͼ
	public static BufferedImage gameover; // ��Ϸ����ͼ
	public static BufferedImage airplane; // �л�ͼ
	public static BufferedImage bee; // С�۷�ͼ
	public static BufferedImage bullet; // �ӵ�ͼ
	public static BufferedImage hero0; // Ӣ�ۻ�ͼ1
	public static BufferedImage hero1; // Ӣ�ۻ�ͼ2

	public static final int START = 0; // ����״̬
	public static final int RUNNING = 1; // ����״̬
	public static final int PAUSE = 2; // ��ͣ״̬
	public static final int GAME_OVER = 3; // ��Ϸ����״̬
	private int state = 0; // ��ǰ״̬

	private Hero hero = new Hero(); // Ӣ�ۻ�����
	private FlyingObject[] flyings = {}; // ����(�л�+С�۷�)����
	private Bullet[] bullets = {}; // �ӵ�����
	private Timer timer; // ��ʱ��
	private int intervel = 10; // ʱ����(�Ժ���Ϊ��λ)

	static { // ��ʼ����̬��Դ
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

	/** ������ɵ���(�л�+С�۷�)���� */
	public static FlyingObject nextOne() {
		Random rand = new Random(); // ���������
		int type = rand.nextInt(20); // ����0��19֮��������
		if (type == 0) {
			return new Bee(); // Ϊ0ʱ�����۷����
		} else {
			return new Airplane(); // 1��19ʱ���صл�����
		}
	}

	int flyEnteredIndex = 0; // �����볡����

	/** �����볡 */
	public void enterAction() { // 10������һ��
		flyEnteredIndex++; // 10������1
		if (flyEnteredIndex % 40 == 0) { // ÿ400(10*40)������һ��
			FlyingObject one = nextOne(); // ��ȡ������˶���
			flyings = (FlyingObject[]) Arrays.copyOf(flyings,
					flyings.length + 1); // ����
			flyings[flyings.length - 1] = one; // �����˴洢��flyings�����е����һ��Ԫ��
		}
	}

	/** ��������һ�� */
	public void stepAction() { // 10������һ��
		hero.step(); // Ӣ�ۻ���һ��
		for (int i = 0; i < flyings.length; i++) { // �������е���(�л�+С�۷�)
			flyings[i].step(); // ������һ��
		}
		for (int i = 0; i < bullets.length; i++) { // ���������ӵ�
			bullets[i].step(); // �ӵ���һ��
		}
	}

	int shootIndex = 0; // Ӣ�ۻ������ӵ�������

	/** �ӵ��볡(Ӣ�ۻ��������˵�) */
	public void shootAction() { // 10������һ��
		shootIndex++; // 10������1
		if (shootIndex % 30 == 0) { // ÿ300(10*30)������һ��
			Bullet[] bs = hero.shoot(); // ��ȡӢ�ۻ�������ӵ�����
			bullets = (Bullet[]) Arrays.copyOf(bullets, bullets.length
					+ bs.length); // ����(bs�м������伸��)
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length,
					bs.length); // ׷������
		}
	}

	/** �����ӵ������е�����ײ */
	public void bangAction() { // 10������һ��
		for (int i = 0; i < bullets.length; i++) {
			bang(bullets[i]); // һ���ӵ������е���ײ
		}
	}

	private int score = 0; // �÷�

	/** һ���ӵ������е�����ײ */
	public void bang(Bullet bullet) {
		int index = -1; // ��ײ�ĵ�������
		for (int i = 0; i < flyings.length; i++) { // �������е���
			FlyingObject f = flyings[i]; // ��ȡÿһ������
			if (f.shootBy(bullet)) { // ײ����
				index = i; // ��¼����ײ��������
				break;
			}
		}
		if (index != -1) { // ײ����
			FlyingObject one = flyings[index]; // ��ȡ��ײ�ĵ��˶���
			if (one instanceof Enemy) { // �ǵ���
				Enemy e = (Enemy) one; // ����ײ����ǿתΪEnemy����
				score += e.getScore(); // �÷�
			}
			if (one instanceof Award) { // �ǽ���
				Award a = (Award) one; // ����ײ����ǿתΪAward����
				int type = a.getType(); // ��ȡ��������
				switch (type) { // ���ݽ������ͻ�ȡ��ͬ����
				case Award.DOUBLE_FIRE: // ����������Ϊ����ֵ
					hero.addDoubleFire(); // Ӣ�ۻ�������
					break;
				case Award.LIFE: // ����������Ϊ��
					hero.addLife(); // Ӣ�ۻ�����
					break;
				}
			}
			// ����ײ���������һ��Ԫ�ؽ���
			FlyingObject f = flyings[index];
			flyings[index] = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = f;
			// ����(ɾ�����һ��Ԫ�أ�����ײ�ĵ���)
			flyings = (FlyingObject[]) Arrays.copyOf(flyings,
					flyings.length - 1);
		}
	}

	/** ɾ��Խ��ķ����� */
	public void outOfBoundsAction() {
		int index = 0; // 1.��Խ������������� 2.��Խ����˸���
		FlyingObject[] flyingLives = new FlyingObject[flyings.length]; // ��Խ���������
		for (int i = 0; i < flyings.length; i++) { // �������е���
			FlyingObject f = flyings[i]; // ��ȡÿһ������
			if (!f.outOfBounds()) { // ��Խ��
				flyingLives[index++] = f; // ����Խ�������ӵ���Խ����������У�ͬʱ����Խ����˸�����1
			}
		}
		flyings = (FlyingObject[]) Arrays.copyOf(flyingLives, index); // ����Խ��������鸴�Ƶ�flyings��flyings���鳤��Ϊindex

		index = 0; // ����/����������
		Bullet[] bulletLives = new Bullet[bullets.length]; // ��Խ���ӵ�����
		for (int i = 0; i < bullets.length; i++) { // ���������ӵ�
			Bullet b = bullets[i]; // ��ȡÿһ���ӵ�
			if (!b.outOfBounds()) { // ��Խ��
				bulletLives[index++] = b; // ����Խ���ӵ���ӵ���Խ���ӵ������У�ͬʱ����Խ���ӵ�������1
			}
		}
		bullets = (Bullet[]) Arrays.copyOf(bulletLives, index); // ����Խ���ӵ����鸴�Ƶ�bullets��bullets���鳤��Ϊindex
	}

	/** �����Ϸ�Ƿ���� */
	public void checkGameOverAction() { // 10����
		if (isGameOver()) { // ��Ϸ����ʱ
			state = GAME_OVER; // ���õ�ǰ״̬Ϊ��Ϸ����״̬
		}
	}

	/** �ж���Ϸ�Ƿ���� ����true��ʾ��Ϸ���� */
	public boolean isGameOver() {
		for (int i = 0; i < flyings.length; i++) { // �������е���
			FlyingObject f = flyings[i]; // ��ȡÿһ������
			if (hero.hit(f)) { // ײ����
				hero.subtractLife(); // Ӣ�ۻ�����
				hero.setDoubleFire(0); // Ӣ�ۻ�����ֵ����

				// ������ײ���������һ��Ԫ��
				FlyingObject t = flyings[i];
				flyings[i] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = t;
				// ����(ɾ�����һ��Ԫ�أ�����ײ�ĵ��˶���)
				flyings = (FlyingObject[]) Arrays.copyOf(flyings,
						flyings.length - 1);
			}
		}

		return hero.getLife() <= 0; // Ӣ�ۻ�����С�ڻ����0ʱ��Ϸ����
	}

	/** ����ִ�� */
	public void action() {
		// ��������������
		MouseAdapter l = new MouseAdapter() {
			/** ����ƶ��¼����� */
			public void mouseMoved(MouseEvent e) {
				if (state == RUNNING) { // ����ʱ
					int x = e.getX(); // ��ȡ����x����
					int y = e.getY(); // ��ȡ����y����
					hero.moveTo(x, y); // Ӣ�ۻ�������궯
				}
			}

			/** ������¼����� */
			public void mouseClicked(MouseEvent e) {
				switch (state) {
				case START: // ����״̬ʱ
					state = RUNNING; // ��Ϊ����״̬
					break;
				case GAME_OVER: // ��Ϸ����״̬ʱ
					score = 0; // �����ֳ�
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START; // ��Ϊ����״̬
					break;
				}
			}

			/** ����ƿ��¼����� */
			public void mouseExited(MouseEvent e) {
				if (state == RUNNING) { // ����״̬ʱ
					state = PAUSE; // ��Ϊ��ͣ״̬
				}
			}

			/** ��������¼����� */
			public void mouseEntered(MouseEvent e) {
				if (state == PAUSE) { // ��ͣ״̬ʱ
					state = RUNNING; // ��Ϊ����״̬
				}
			}
		};
		this.addMouseListener(l); // �����������¼�
		this.addMouseMotionListener(l); // ������껬���¼�

		timer = new Timer(); // ������ʱ������
		timer.schedule(new TimerTask() {
			public void run() { // ��ʱ�ɵ��£�10������һ��
				if (state == RUNNING) { // ����״̬ʱ
					enterAction(); // ����(�л�+С�۷�)�볡
					stepAction(); // ��������һ��
					shootAction(); // �ӵ��볡(Ӣ�ۻ������ӵ�)
					bangAction(); // �ӵ��������ײ
					outOfBoundsAction(); // ɾ��Խ��ķ�����
					checkGameOverAction(); // �����Ϸ�Ƿ����
				}
				repaint(); // �ػ�(����paint()����)
			}
		}, intervel, intervel);
	}

	/** ��дpaint() g:���� */
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null); // ������ͼ
		paintHero(g); // ��Ӣ�ۻ�����
		paintFlyingObjects(g); // ������(�л�+С�۷�)����
		paintBullets(g); // ���ӵ�����
		paintScore(g); // ���ֺͻ���
		paintState(g); // ��״̬
	}

	/** ��Ӣ�ۻ� */
	public void paintHero(Graphics g) {
		g.drawImage(hero.image, hero.x, hero.y, null); // ��Ӣ�ۻ�����
	}

	/** ������ */
	public void paintFlyingObjects(Graphics g) {
		for (int i = 0; i < flyings.length; i++) { // �������е���
			FlyingObject f = flyings[i]; // ��ȡÿһ������
			g.drawImage(f.image, f.x, f.y, null); // �����˶���
		}
	}

	/** ���ӵ� */
	public void paintBullets(Graphics g) {
		for (int i = 0; i < bullets.length; i++) { // ���������ӵ�
			Bullet b = bullets[i]; // ��ȡÿһ���ӵ�
			g.drawImage(b.image, b.x, b.y, null); // ���ӵ�����
		}
	}

	/** ���ֺͻ��� */
	public void paintScore(Graphics g) {
		g.setColor(new Color(0xFF0000)); // ������ɫΪ��ɫ
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20)); // ������ʽ(SANS_SERIF:����
		// BOLD:������ʽ�Ӵ�
		// 20:�ֺ�)
		g.drawString("SCORE: " + score, 10, 25); // ����
		g.drawString("LIFE: " + hero.getLife(), 10, 45); // ����
	}

	/** ��״̬ */
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

	/** ������ */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Flyllll"); // ����
		ShootGame game = new ShootGame(); // ���
		frame.add(game); // �������ӵ�������
		frame.setSize(WIDTH, HEIGHT); // ���ô��ڴ�С
		frame.setAlwaysOnTop(true); // ����һֱ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����Ĭ�Ϲرղ���--�رմ���ʱ�˳�����
		frame.setLocationRelativeTo(null); // �������λ��Ϊnull����:����
		frame.setVisible(true); // 1.���ô��ڿɼ� 2.�������paint()����

		game.action(); // ����ִ��

	}
}
