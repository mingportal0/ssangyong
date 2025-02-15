/**
 * @Class Name : MailService.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 8. 5.           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2019. 8. 5. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 */
package com.zim.member.mail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

/**
 * @author sist
 *
 */
public class MailService {
	final static Logger LOG = Logger.getLogger(MailService.class);
	
	public int do_send_mail(MailVO inVO){
		LOG.debug("----------------------------------");
		LOG.debug("do_send_mail");
		LOG.debug("----------------------------------");
		int flag = 0;
		//1.발신자의 mail계정과 비번
		String host = "smtp.naver.com"; //naver smtp
		String user = "nmjgo7321@naver.com"; //naver 사용자 아이디
		String password = "audwls5683^^"; //naver mail 비번
		
		//2.Property에 SMTP 서버정보 설정
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);
		
		//3.SMTP 서버정보와 사용자 정보를 기반으로 Session클래스의 인스턴스를 생성한다.
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(user, password);
			}
		});
		try{
			//4.Message클래스를 사용하여 수신자와 내용, 제목, Message를 작성한다.
			MimeMessage message = new MimeMessage(session);
			//from user
			message.setFrom(new InternetAddress(user));
			//to user
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(inVO.getMailTO()));
			//4.3.제목
			message.setSubject(inVO.getTitle());
			//4.4.내용
			message.setContent(inVO.getContents(),"text/html;charset=UTF-8");
			
			//5.Transport 클래스를 사용하여 작성한 메세지를 전달한다.
			Transport.send(message);
			LOG.debug("Mal Send Success.");
			
		}catch(MessagingException e ){
			LOG.debug("--------------------------");
			LOG.debug(e.toString());
			LOG.debug("--------------------------");
			return flag;
		}
		flag = 1;
		return flag;
	}
	public String make_contents(String userId, String passWd){
		//현재시간 구하기
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
		String now = df.format(date);
		
		//내용 생성
		StringBuffer  sb = new StringBuffer();		
		sb.append("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />								  ");
		sb.append("<!DOCTYPE html>																						  ");
		sb.append(" <html>                                                                                                ");
		sb.append(" <body style='@import url\\(http://fonts.googleapis.com/earlyaccess/nanumgothic.css\\); margin:10px; font-family: 'Nanum Gothic', sans-serif;'>                                                                                                ");
		sb.append(" 	<div><br/><h3>회원님의 <a style='color: #FBB710;'>비밀번호</a>가 변경되었습니다.</h3><br/></div>	                              ");
		sb.append(" 	<hr/>                                                                                             ");
		sb.append(" 	<p>안녕하세요. "+userId+" 회원님.</p>                                                                  ");
		sb.append(" 	<p>회원님의 비밀번호 변경 내역을 안내해 드립니다.</p>                                                   ");
		sb.append(" 	<hr/>                                                                                             ");
		sb.append(" 	<br/>                                                                                             ");
		sb.append(" 	<h4>비밀번호 변경에 따른 안내</h4>                                                                   ");
		sb.append(" 	<br/>                                                                                             ");
		sb.append(" 	<table>                                                                                           ");
		sb.append(" 		<tr>                                                                                          ");
		sb.append(" 			<td>변경 일시</td>                                                                         ");
		sb.append(" 			<td>"+now+"</td>                                                          ");
		sb.append(" 		</tr>                                                                                         ");
		sb.append(" 		<tr>                                                                                          ");
		sb.append(" 			<td>비밀 번호</td>                                                                         ");
		sb.append(" 			<td><h5>"+passWd+"</h5></td>                                                                          ");
		sb.append(" 		</tr>                                                                                         ");
		sb.append(" 	</table>                                                                                          ");
		sb.append(" 	<br/>                                                                                             ");
		sb.append(" 	<p>비밀번호를 변경한 적이 없는데 메일을 받았다면 다른 사람이 내 계정 정보를 알아내 변경했을 수 있습니다.</p>  ");
		sb.append(" 	<p>비밀번호 찾기를 통해 <a style='color: #FBB710;'>비밀번호를 재설정</a> 해 주세요.</p>                                         ");
		sb.append(" 	<p>짐살라빔 이용해 주셔서 감사합니다.</p>                                                             ");
		sb.append(" 	<p>더욱 편리한 서비스를 제공하기 위해 항상 최선을 다하겠습니다.</p>                                      ");
		sb.append(" 	<br/>                                                                                             ");
		sb.append(" 	<h5>본 메일은 발신전용 입니다. 짐살라빔 서비스관련 궁금하신 사항은 짐살라빔 고객센터에서 확인해주세요.</h5>   ");
		sb.append(" 	<h5>Copyright ⓒZIMZALABIM Corp. All Rights Reserved.</h5>                                        ");
		sb.append(" </body>                                                                                               ");
		sb.append(" </html>                                                                                               ");
		
		LOG.debug("--------------------------");
		LOG.debug(sb.toString());
		LOG.debug("--------------------------");
		return sb.toString();
	}
	
}
