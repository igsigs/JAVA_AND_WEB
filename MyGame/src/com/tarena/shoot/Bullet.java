package com.tarena.shoot;

/** 子弹: 是飞行物 */
public class Bullet extends FlyingObject { // 子弹
	private int speed = 2; // 走步的步数

	/** 构造方法 x和y要随着英雄机坐标位置，故传参写活 */
	public Bullet(int x, int y) {
		image = ShootGame.bullet; // 图片
		width = image.getWidth(); // 宽
		height = image.getHeight();// 高
		this.x = x; // x:随着英雄机位置
		this.y = y; // y:随着英雄机位置
	}

	/** 重写step() */
	public void step() {
		y -= speed; // y减,x不变
	}

	/** 重写outOfBounds() */
	public boolean outOfBounds() {
		return this.y < -this.height; // 子弹的y小于负的子弹的高时越界
	}
}
