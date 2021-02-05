package com.urban.spatium.encryption;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor(); 
		pbeEnc.setAlgorithm("PBEWithMD5AndDES"); 
		pbeEnc.setPassword("ksmart37"); 
<<<<<<< HEAD
		String url = "jdbc:log4jdbc:mysql://coral8501.cafe24.com:3306/coral8501?serverTimezone=Asia/Seoul&characterEncoding=UTF8&zeroDateTimeBehavior=convertToNull"; 
		String username = "coral8501"; 
		String password = "milktea28"; 
		System.out.println("기존 URL :: " + url + " | 변경 URL :: " + pbeEnc.encrypt(url)); 
		System.out.println("기존 username :: " + username + " | 변경 username :: " + pbeEnc.encrypt(username)); 
		System.out.println("기존 password :: " + password + " | 변경 password :: " + pbeEnc.encrypt(password));
		System.out.println(pbeEnc.decrypt("7FqzZlatahsHWanAnHNMvQ=="));
		System.out.println(pbeEnc.decrypt("XZeoafDFft+Eur4PGPK5I6pgW3btnp/e"));
=======
//		String url = "jdbc:log4jdbc:mysql://kissmekj.cafe24.com:3306/kissmekj?serverTimezone=Asia/Seoul&characterEncoding=UTF8&zeroDateTimeBehavior=convertToNull"; 
//		String username = "kissmekj"; 
//		String password = "nr09241844"; 
		String url = "jdbc:log4jdbc:mysql://atomkh.cafe24.com:3306/atomkh?serverTimezone=Asia/Seoul&characterEncoding=UTF8&zeroDateTimeBehavior=convertToNull"; 
		String username = "atomkh"; 
		String password = "zmfkzps2ek"; 
		System.out.println("기존 URL :: " + url + " | 변경 URL :: " + pbeEnc.encrypt(url)); 
		System.out.println("기존 username :: " + username + " | 변경 username :: " + pbeEnc.encrypt(username)); 
		System.out.println("기존 password :: " + password + " | 변경 password :: " + pbeEnc.encrypt(password));
		System.out.println(pbeEnc.decrypt("1wzDoN1wxIuUz+2egfQ5nQ=="));
		System.out.println(pbeEnc.decrypt("xr3YZWmnFHUq1lVzu7smkTlNA1aiDgnH"));
>>>>>>> branch 'SHY' of https://github.com/merrycoral/hy_spatium
	}
}