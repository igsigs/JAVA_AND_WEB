package com.tarena.shoot;

import java.awt.image.BufferedImage;

/** Ӣ�ۻ�: �Ƿ����� */
public class Hero extends FlyingObject {
	private int life; // ��
	private int doubleFire; // ����ֵ
	private BufferedImage[] images; // ͼƬ����
	private int index; // �����л���Ƶ��

	/** ���췽�� */
	public Hero() {
		image = ShootGame.hero0; // ͼƬ
		width = image.getWidth(); // ��
		height = image.getHeight(); // ��
		x = 150; // x:�̶���150
		y = 400; // y:�̶���400
		life = 433; // 3����
		doubleFire = 0; // ����ֵ0,����������
		images = new BufferedImage[] { ShootGame.hero0, ShootGame.hero1 }; // ����ͼƬ
		index = 6; // Э���л�ͼƬ
	}

	/** ��дstep() */
	public void step() { // 10������һ��
		image = images[index++ / 10 % images.length]; // ÿ100�����л�һ��
		/*
		 * index++; int a = index/10; int b = a%2; image = images[b];
		 */
		/*
		 * 10m index=1 a=0 b=0 20m index=2 a=0 b=0 30m index=3 a=0 b=0 ... 100m
		 * index=10 a=1 b=1 110m index=11 a=1 b=1 120m index=12 a=1 b=1 ... 200m
		 * index=20 a=2 b=0 210m index=21 a=2 b=0 ... 300m index=30 a=3 b=1
		 */
	}

	/** Ӣ�ۻ�����һ���ӵ� */
	public Bullet[] shoot() {
		int xStep = this.width / 4; // Ӣ�ۻ���1/4��
		if (doubleFire > 0) { // ˫��
			Bullet[] bullets = new Bullet[2];
			bullets[0] = new Bullet(this.x + 1 * xStep, this.y - 20); // x:Ӣ�ۻ�x+1/4Ӣ�ۻ���
																		// y:Ӣ�ۻ�y-20
			bullets[1] = new Bullet(this.x + 3 * xStep, this.y - 20); // x:Ӣ�ۻ�x+3/4Ӣ�ۻ���
																		// y:Ӣ�ۻ�y-20
			doubleFire -= 2; // ����һ��˫��������ֵ��2
			return bullets;
		} else { // ����
			Bullet[] bullets = new Bullet[1];
			bullets[0] = new Bullet(this.x + 2 * xStep, this.y - 20); // x:Ӣ�ۻ�x+2/4Ӣ�ۻ���
																		// y:Ӣ�ۻ�y-20
			return bullets;
		}
	}

	/** Ӣ�ۻ���������ƶ� x:����x y:����y */
	public void moveTo(int x, int y) {
		this.x = x - this.width / 2; // Ӣ�ۻ���x=����x-1/2Ӣ�ۻ��Ŀ�
		this.y = y - this.height / 2;// Ӣ�ۻ���y=����y-1/2Ӣ�ۻ��ĸ�
	}

	/** ���� */
	public void addLife() {
		life++; // ������1
	}

	/** ��ȡ�� */
	public int getLife() {
		return life;
	}

	/** ���� */
	public void subtractLife() {
		life--; // ������1
	}

	/** ������ֵ */
	public void addDoubleFire() {
		doubleFire += 40; // ����ֵ��40
	}

	/** ���û���ֵ */
	public void setDoubleFire(int doubleFire) {
		this.doubleFire = doubleFire;
	}

	/** ��дoutOfBounds() */
	public boolean outOfBounds() {
		return false; // ����Խ��
	}

	/** �ж�Ӣ�ۻ�����˵���ײ this:Ӣ�ۻ� other:���� */
	public boolean hit(FlyingObject other) {
		int x1 = other.x - this.width / 2; // x1:���˵�x-1/2Ӣ�ۻ��Ŀ�
		int x2 = other.x + other.width + this.width / 2; // x2:���˵�x+���˵Ŀ�+1/2Ӣ�ۻ��Ŀ�
		int y1 = other.y - this.height / 2; // y1:���˵�y-1/2Ӣ�ۻ��ĸ�
		int y2 = other.y + other.height + this.height / 2; // y2:���˵�y+���˵ĸ�+1/2Ӣ�ۻ��ĸ�
		int hx = this.x + this.width / 2; // hx:Ӣ�ۻ���x+1/2Ӣ�ۻ��Ŀ�
		int hy = this.y + this.height / 2; // hy:Ӣ�ۻ���y+1/2Ӣ�ۻ��ĸ�

		return hx > x1 && hx < x2 && hy > y1 && hy < y2; // ����hx��x1��x2֮�䣬���ң�hy��y1��y2֮��Ľ��

	}

}
