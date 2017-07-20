package com.tarena.shoot;

/** �ӵ�: �Ƿ����� */
public class Bullet extends FlyingObject { // �ӵ�
	private int speed = 2; // �߲��Ĳ���

	/** ���췽�� x��yҪ����Ӣ�ۻ�����λ�ã��ʴ���д�� */
	public Bullet(int x, int y) {
		image = ShootGame.bullet; // ͼƬ
		width = image.getWidth(); // ��
		height = image.getHeight();// ��
		this.x = x; // x:����Ӣ�ۻ�λ��
		this.y = y; // y:����Ӣ�ۻ�λ��
	}

	/** ��дstep() */
	public void step() {
		y -= speed; // y��,x����
	}

	/** ��дoutOfBounds() */
	public boolean outOfBounds() {
		return this.y < -this.height; // �ӵ���yС�ڸ����ӵ��ĸ�ʱԽ��
	}
}
