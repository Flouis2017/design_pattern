package com.flouis.tool;


import org.apache.commons.codec.digest.DigestUtils;

public class MD5Tool {

	/**
	 * MD5加密
	 * @param text 明文(用户输入的密码)
	 * @param key 密钥(盐值)
	 * @return 密文(数据库中存放的实际密码)
	 * @throws Exception
	 */
	public static String md5(String text, String key) throws Exception {
		String md5Hex= DigestUtils.md5Hex(text + key);
		return md5Hex;
	}

	/**
	 * MD5验证
	 * @param text 明文
	 * @param key 密钥
	 * @param md5 密文
	 * @return true/false
	 * @throws Exception
	 */
	public static boolean verify(String text, String key, String md5) throws Exception {
		//根据传入的密钥进行验证
		String md5Hex = md5(text, key);
		return md5.equalsIgnoreCase(md5Hex) ? true : false;
	}

	public static void main(String[] args) {
		String password = "123456";
		String salt = "WHOSYOURDADDY";
		try {
			System.out.println(md5(password, "xxx")); // e087dae60e744ea80722b785a75adbb7
			System.out.println(md5(password, salt)); // bc7712c1baff2d6d36efa20a0ef09137
			System.out.println(verify(password, salt, "bc7712c1baff2d6d36efa20a0ef09137"));
		} catch (Exception e){
			e.printStackTrace();
		}
	}


}
