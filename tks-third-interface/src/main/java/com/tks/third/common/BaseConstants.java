package com.tks.third.common;

public class BaseConstants {
	public enum DataSource{
		SN("1"),MANUAL("2"),OTHER("3");
		private String type;
		private DataSource(String type) {
			this.type = type;
		}
		
		public String getType(){
			return this.type;
		}
	}
}
