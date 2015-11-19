package com.osndroid.cttms.model.pla.respone;

import com.osndroid.cttms.model.pla.News;
import com.osndroid.cttms.model.pla.Music;

/**
 *  音乐消息响应类
 * @author OsnDroid
 *
 */
public class MusicResp extends News {

	private Music music;
	private String funcFlag;

	public String getFuncFlag() {
		return funcFlag;
	}

	public void setFuncFlag(String funcFlag) {
		this.funcFlag = funcFlag;
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

}
