package com.osndroid.cttms.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;


/**
 * 加载配置文件
 * 
 * @author OsnDroid
 *
 */
public class OsnProperties {
	private static OsnProperties osnProperties;
	private Properties prop;
	private static final Logger log = Logger.getLogger(OsnProperties.class);

	private OsnProperties() {
		init();
	}

	private void init() {
		InputStream in = null;
		try {
			log.info("装载osn_dualchat_config.properties文件...");
			String filename = (System.getProperty("user.dir") + "/etc/osn_dualchat_config.properties")
					.replaceAll("\\\\", "/");
			File file = new File(filename);
			if (file.exists()) {
				in = new FileInputStream(file);
				log.info("加载配置文件---" + file.getAbsolutePath());
			} else {
				in = getClass().getResourceAsStream("/osn_dualchat_config.properties");
				log.info("加载配置文件---/osn_dualchat_config.properties");
			}

			this.prop = new Properties();
			this.prop.load(in);
			log.info("读取配置文件osn_dualchat_config.properties成功.");
		} catch (Exception e) {
			System.out.println("初始化osn_dualchat Config失败.");
			log.error("初始化osn_dualchat Config失败.");
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in = null;
			}
		}
	}

	private Properties getProp() {
		return this.prop;
	}

	private static synchronized OsnProperties getInstance() {
		if (osnProperties == null)
			osnProperties = new OsnProperties();
		return osnProperties;
	}

	public static String getParameter(String key) {
		return getInstance().getProp().getProperty(key);
	}
}