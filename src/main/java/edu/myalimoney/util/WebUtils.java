package edu.myalimoney.util;

import javax.servlet.http.HttpServletRequest;


public class WebUtils {

	public final static Boolean SUCCESS_RESULT = true;
	public final static Boolean ERROR_RESULT = false;
	public final static int SUCCESS_STATUS = 0;
	public final static String SUCCESS_MESSAGE = "操作成功";
	public final static int WRONG_STATUS = -1;
	public final static String WRONG_MESSAGE = "系统异常";
	public final static int ERROR_STATUS = -2;
	public final static String ERROR_PARAM ="参数不正确";
	public final static String ERROR_MESSAGE = "缺少参数";
	public final static int ERROR_CUSTOMER = -3;
	public final static String ERROR__MESSAGE = "操作失败";
	public final static String ERROR_CUSTOMER_MESSAGE = "账号不存在";
	public final static int ERROR_CUSTOMER_PASSWORD = -4;
	public final static String ERROR_CUSTOMER_PASSWORD_MESSAGE = "密码错误";
	public final static int ERROR_CUSTOMER_STATUS = -5;
	public final static String ERROR_CUSTOMER_STATUS_MESSAGE = "账号状态异常";
	public final static int ERROR_CUSTOMER_PHONE = -6;
	public final static String ERROR_CUSTOMER_PHONE_MESSAGE = "重新验证登录";
	public final static int ERROR_CUSTOMER_LOGIN = -7;
	public final static String ERROR_CUSTOMER_LOGIN_MESSAGE = "重新登录";
	public final static int MOBILE_EXISTENCE = -8;
	public final static String MOBILE_EXISTENCE_MESSAGE = "手机号已经存在";
	public final static int ERROR_VAILDTECODE_SEND = -9;
	public final static String ERROR_VAILDTECODE_SEND_MESSAGE = "验证码发送失败";
	public final static String ERROR_VAILDTECODE_CHECK_MESSAGE = "验证失败";
	public final static String ERROR_RETRIEVE_PWD_MESSAGE = "手机或邮箱不合法";
	public final static String MOBILE_NOT_REGISTERED_MESSAGE = "该手机号未注册";
	public final static String MAILBOX_NOT_BOUND_MESSAGE = "该邮箱未绑定";
	public final static String MAILBOX_NOT_VERIFIED_MESSAGE = "该邮箱未通过验证";
	public final static int ERROR_PAY_STATUS = -10;
	public final static String ERROR_PAY_MESSAGE = "支付密码等相关标识错误";
	public final static String PAY_LACK_MESSAGE = "账户金币不足";
	public final static String PAY_GOLD_MESSAGE = "账户金币不足";
	public final static String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	public final static String ADMIN = "admin";
	public final static int ERROR_AUDIT = -11; 
	
	/**
	 * 统一自定义异常
	 * 
	 * @param wrong
	 * @param status
	 * @param text
	 */
//	public static void checkState(boolean wrong, int status, String text) {
//		if (wrong) {
//			throw new CommonException(status, text);
//		}
//	}

	/**
	 * 非法字符判断
	 * 
	 * @param input
	 */
	public static boolean isValueSuccessed(String input) {
		boolean flag = false;
		if ((input != null) && (input.length() > 0)) {
			char c = '0';
			for (int i = 0; i <= input.length() - 1; i++) {
				c = input.charAt(i);
				switch (c) {
				case '>':
					flag = true;
					break;
				case '<':
					flag = true;
					break;
				/*case '=':
					flag = true;
					break;
				case '&':
					flag = true;
					break;*/
				// case '"':flag=true;break;
				/*case '(':
					flag = true;
					break;
				case ')':
					flag = true;
					break;
				case '+':
					flag = true;
					break;*/
				}
			}
		}
		return flag;
	}
	
	/**
	 * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址, 
	 * 
	 * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
	 * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。 
	 * 
	 * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130, 192.168.1.100
	 * 
	 * 用户真实IP为： 192.168.1.110
	 * 
	 * @Title: PrivilegeInterceptor
	 * @param request
	 * @return String
	 * @throws
	 * 
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
}
