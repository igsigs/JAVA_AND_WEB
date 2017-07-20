package com.tarena.shoot;

import java.util.Random;

/** 小蜜蜂: 是飞行物，也是奖励 */
public class Bee extends FlyingObject implements Award {
	private int xSpeed = 1; // x坐标走步步数
	private int ySpeed = 3; // y坐标走步步数
	private int awardType; // 奖励类型

	/** 构造方法 */
	public Bee() {
		image = ShootGame.bee; // 图  片
		width = image.getWidth(); // 宽
		height = image.getHeight(); // 高
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - this.width); // x:0到屏幕宽-蜜蜂宽之间的随机数
		y = -this.height; // y:负的蜜蜂的高
		awardType = rand.nextInt(2); // 0到1之间的随机数 0代表火力值 1代表命
	}

	/** 重写getType() */
	public int getType() {
		return awardType; // 返回奖励类型
	}

	/** 重写step() */
	public void step() {
		x += xSpeed; // x增
		y += ySpeed; // y增
		if (this.x >= ShootGame.WIDTH - this.width) { // 蜜蜂x>=屏幕宽-蜜蜂宽
			xSpeed = -1; // xSpeed为-1，即减1，即向左
		}
		if (this.x <= 0) { // 蜜蜂x<=0
			xSpeed = 1; // xSpeed为1，即增1，即向右
		}
	}

	/** 重写outOfBounds() */
	public boolean outOfBounds() {
		return this.y > ShootGame.HEIGHT; // 敌机的y大于屏幕的高为越界
	}
}
