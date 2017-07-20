package com.tarena.shoot;

import java.util.Random;

/** 敌机: 是飞行物，也是敌人 */
public class Airplane extends FlyingObject implements Enemy {
	private int speed = 1; // 走步的步数

	/** 构造方法 */
	public Airplane() {
		image = ShootGame.airplane; // 图片
		width = image.getWidth(); // 宽
		height = image.getHeight(); // 高
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - this.width); // x:0到屏幕宽-敌机宽之间的随机数
		y = -this.height; // y:负的敌机的高
	}

	
	/** 重写getScore() */
	public int getScore() {
		return 999999; // 打掉一个敌机得5分
	}

	/** 重写step() */
	public void step() {
		y += speed; // y增,x不变
	}

	/** 重写outOfBounds() */
	public boolean outOfBounds() {
		return this.y > ShootGame.HEIGHT; // 敌机的y大于屏幕的高为越界
	}
}
