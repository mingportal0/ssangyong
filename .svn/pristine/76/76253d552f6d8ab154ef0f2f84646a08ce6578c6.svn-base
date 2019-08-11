package com.zim.cmn;

import com.zim.cmn.DTO;

public class MessageVO extends DTO {

		private String msgId;
		private String msgContents;
		private String msgproductNo;
		//msgId>0:성공
		//msgId<=0:실패
		public MessageVO(){			
		}
		public MessageVO(String msgId, String msgContents){
			super();
			this.msgId = msgId;
			this.msgContents = msgContents;
		}
		public MessageVO(String msgId, String msgContents, String msgproductNo) {
			super();
			this.msgId = msgId;
			this.msgContents = msgContents;
			this.msgproductNo = msgproductNo;
		}

		public String getMsgId() {
			return msgId;
		}
		public void setMsgId(String msgId) {
			this.msgId = msgId;
		}
		public String getMsgContents() {
			return msgContents;
		}
		public void setMsgContents(String msgContents) {
			this.msgContents = msgContents;
		}
		public String getMsgproductNo() {
			return msgproductNo;
		}
		public void setMsgproductNo(String msgproductNo) {
			this.msgproductNo = msgproductNo;
		}

		@Override
		public String toString() {
			return "MessageVO [msgId=" + msgId + ", msgContents=" + msgContents + ", msgproductNo=" + msgproductNo
					+ ", toString()=" + super.toString() + "]";
		}
		
		
		
}
