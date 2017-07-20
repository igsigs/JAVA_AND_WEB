package com.tarena.shoot;

/** 奖励 */
public interface Award { // 奖品
	int DOUBLE_FIRE = 8; // 火力值
	int LIFE = 9; // 命

	/** 获取奖励类型 */
	public int getType();
}
