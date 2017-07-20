package com.tarena.shoot;

import java.awt.image.BufferedImage;

/** 飞行物 */
public abstract class FlyingObject {
	public BufferedImage image; // 贴图
	public int width; // 宽
	public int height;// 高
	public int x; // x坐标
	public int y; // y坐标

	/** 飞行物走一步 */
	public abstract void step(); // 步

	/** 敌人与子弹的碰撞 this:敌人 bullet:子弹 */
	public boolean shootBy(Bullet bullet) {
		int x1 = this.x; // x1:敌人的x
		int x2 = this.x + this.width; // x2:敌人的x+敌人的宽
		int y1 = this.y; // y1:敌人的y
		int y2 = this.y + this.height;// y2:敌人的y+敌人的高
		int bx = bullet.x; // bx:子弹的x
		int by = bullet.y; // by:子弹的y

		return bx > x1 && bx < x2 && by > y1 && by < y2; // 返回bx在x1与x2之间，并且，by在y1与y2之间
	}

	/** 判断飞行物是否越界 */
	public abstract boolean outOfBounds();

}
