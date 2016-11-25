package com.andieguo.enumdemo;

import junit.framework.TestCase;

public class EnumTester extends TestCase {
	
	public enum SensorKey {
		
		KEY_Information("Information", "key_Information"), 
		KEY_Light("Light", "key_Light"), 
		KEY_Appliance("Appliance", "key_Appliance");
		
		private String activity;
		private String key;

		private SensorKey(String activity, String key) {// ˽�еĻ��Ѻõ�
			this.key = key;
			this.activity = activity;
		}

		public String getKey() {
			return key;
		}

		public String getActivity() {
			return activity;
		}
	}

	public void test() {
		System.out.println(SensorKey.KEY_Appliance.getKey());
	}

	public void test2() {
		for (SensorKey sensorKey : SensorKey.values()) {// ����ö��
			System.out.println(sensorKey.getKey() + ":" + sensorKey.getActivity());
		}
	}
}
