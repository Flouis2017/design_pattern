package com.flouis.test;

import org.junit.Test;

public class ToolTest {

	@Test
	public void MyTest(){

		String str = "activity,announcement,area,award,balance_log,banner,category,count_day_users,coupons,coupons_good,coupons_user,dict,exchange_code,fans,favorite,feedback,feedback_image,filter,flash_sale,form_id,freight_rule,friend_relationship,friends_apply,good,good_comment,good_comment_image,good_image,good_no_send_area,good_order,good_order_aftersale,good_order_detail,good_order_logistics,good_param,good_selling_point,good_selling_point_rel,goodpic,goodproperty,intimacy_level,intimacy_log,intimacy_rule,invoice,invoice_img,msg,msg_recipient,property,propertyvalue,questionnaire,shopping_cart,sign_log,sku,subject,t_bo_button,t_bo_button_user,t_bo_resource,t_bo_role,t_bo_role_resource,t_bo_role_user,t_bo_user,t_sp_sms_verify_code,topic,topic_comment,topic_image,topic_type,tweet,tweet_comment,tweet_like,winner,wx_user,wx_user_address,wx_user_copy,wx_user_levels";
		String[] tbNameArr = str.split(",");
		String[] classNameArr = getClassName(str.split(","));
		for (String x : classNameArr){
			System.out.print(x + " ");
		}
		System.out.println("\n");

		StringBuffer sb = new StringBuffer();
		sb.setLength(0);
		for (int i = 0; i < tbNameArr.length; i++){
			sb.append("<table tableName=\""+tbNameArr[i]+"\" domainObjectName=\""+classNameArr[i]+"\" \n")
			  .append("\t\tenableCountByExample=\"false\" enableUpdateByExample=\"false\" \n")
			  .append("\t\tenableDeleteByExample=\"false\" enableSelectByExample=\"false\" \n")
			  .append("\t\tselectByExampleQueryId=\"false\"> \n")
			  .append("</table>\n\n");
		}
		System.out.println(sb.toString());

	}

	public static String[] getClassName(String[] argArr){
		String[] resArr = new String[argArr.length];
		for (int i = 0; i < argArr.length; i++){
			argArr[i] = underlineToHump(argArr[i]);
			argArr[i] = toUpperCaseFirstOne(argArr[i]);
			resArr[i] = argArr[i];
		}
		return resArr;
	}


	public static String toUpperCaseFirstOne(String s){
		if(Character.isUpperCase(s.charAt(0))){
			return s;
		}
		return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	public static String underlineToHump(String para){
		StringBuilder result=new StringBuilder();
		String a[]=para.split("_");
		for(String s:a){
			if(result.length()==0){
//				result.append(s);
				result.append(s.toLowerCase());
			}else{
				result.append(s.substring(0, 1).toUpperCase());
				result.append(s.substring(1).toLowerCase());
			}
		}
		return result.toString();
	}

	@Test
	public void test(){
		String tmpStr = "_Day_users";
//		String[] arr = tmpStr.split("_");
//		System.out.println(arr.length);
//		for (String x : arr){
//			System.out.print(x + " ");
//		}
		System.out.println(underlineToHump(tmpStr));
		System.out.println(tmpStr.toUpperCase());
	}

}
