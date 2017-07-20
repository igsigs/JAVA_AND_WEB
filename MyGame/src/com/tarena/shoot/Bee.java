package com.tarena.shoot;

import java.util.Random;

/** С�۷�: �Ƿ����Ҳ�ǽ��� */
public class Bee extends FlyingObject implements Award {
	private int xSpeed = 1; // x�����߲�����
	private int ySpeed = 3; // y�����߲�����
	private int awardType; // ��������

	/** ���췽�� */
	public Bee() {
		image = ShootGame.bee; // ͼ  Ƭ
		width = image.getWidth(); // ��
		height = image.getHeight(); // ��
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - this.width); // x:0����Ļ��-�۷��֮��������
		y = -this.height; // y:�����۷�ĸ�
		awardType = rand.nextInt(2); // 0��1֮�������� 0�������ֵ 1������
	}

	/** ��дgetType() */
	public int getType() {
		return awardType; // ���ؽ�������
	}

	/** ��дstep() */
	public void step() {
		x += xSpeed; // x��
		y += ySpeed; // y��
		if (this.x >= ShootGame.WIDTH - this.width) { // �۷�x>=��Ļ��-�۷��
			xSpeed = -1; // xSpeedΪ-1������1��������
		}
		if (this.x <= 0) { // �۷�x<=0
			xSpeed = 1; // xSpeedΪ1������1��������
		}
	}

	/** ��дoutOfBounds() */
	public boolean outOfBounds() {
		return this.y > ShootGame.HEIGHT; // �л���y������Ļ�ĸ�ΪԽ��
	}
}
