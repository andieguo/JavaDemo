package com.andieguo.thread;

//0�����߳������߳���ʱ��Ƭ��ת�ķ�ʽ����CPU��ִ��threadExecute��������һ��ִ�е���threadExecute(business, "sub")��������ִ��business.sub(i)��������Ϊbusiness.sub(i)��synchronized����

//1���Ƿ��п��ܣ�sub��0����ûѭ����������ִ����һ�룩���Ϳ�ʼִ��main(0);
//�����ܣ�sub(0)ͨ��synchronized��ռ����Դ����ʹ�ֵ�main(0)ִ�У�main(0)Ҳ��ִ�еȴ�����sub(0)����ִ�У�

//2���Ƿ��п��ܣ�threadExecute(business, "sub");ִ�е�ʱ���㹻������sub��0��ִ����֮�󣬼���ִ��sub(1),sub��2����֮���ٽ�CPU����threadExecute(business, "main");
//�����ܣ�sub��0��ִ����֮���Լ���һֱ���ڵȴ�״̬������ִ����main��������bool��Ϊfalse��

//3��sub(0) main(0)ִ����һ�ֺ����ִ�е���һ�֣�
//threadExecute(business, "sub");ִ����sub��0��֮�󣬸��̲߳�û��ִ���ֻ꣬�Ǵ��ڵȴ�״̬���ȴ�main(0)ִ����֮�󣬽����ȴ�ִ��sub(1);

//���̣߳�sub(0) sub(1) sub(2)
//���̣߳�main(0) main(1) main(2)

//t1.Join���������ļ���ʹ���߳�t1��������ִ��Ȩ��
public class ThreadTest2 {
	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
				threadExecute(business, "sub");
			}
		}).start();//���߳�
		threadExecute(business, "main");//���߳�

 	}	
	public static void threadExecute(Business business, String threadType) {
		for(int i = 0; i < 10; i++) {
			try {
				if("main".equals(threadType)) {
					business.main(i);
				} else {
					business.sub(i);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
/**
sub thread seq of 0, loop of 0
sub thread seq of 1, loop of 0
main thread seq of 0, loop of 0
main thread seq of 1, loop of 0
main thread seq of 2, loop of 0
main thread seq of 3, loop of 0

sub thread seq of 0, loop of 1
sub thread seq of 1, loop of 1
main thread seq of 0, loop of 1
main thread seq of 1, loop of 1
main thread seq of 2, loop of 1
main thread seq of 3, loop of 1
 * @author Administrator
 *
 */
class Business {
	private boolean bool = true;
	public synchronized void main(int loop) throws InterruptedException {
		while(bool) {
			this.wait();
		}
		/*�ٽ���*/
		for(int i = 0; i < 4; i++) {
			System.out.println("main thread seq of " + i + ", loop of " + loop);
		}
		bool = true;
		this.notify();
	}	
	public synchronized void sub(int loop) throws InterruptedException {
		while(!bool) {
			this.wait();
		}
		/*�ٽ���*/
		for(int i = 0; i < 2; i++) {
			System.out.println("sub thread seq of " + i + ", loop of " + loop);
		}
		bool = false;
		this.notify();//ʹ���ڵȴ�������Դ��main�߳̿�ʼִ�С�
	}
}
/**
 * 
 * �쳣��java.lang.IllegalMonitorStateException
 * ������Ҫ�˽�����쳣Ϊʲô���׳�������쳣��������������׳���
	1>��ǰ�̲߳����е�ǰ���������Դ��ʱ�򣬵���obj.wait()����;
	2>��ǰ�̲߳����е�ǰ���������Դ��ʱ�򣬵���obj.notify()������
	3>��ǰ�̲߳����е�ǰ���������Դ��ʱ�򣬵���obj.notifyAll()������
 * 
 * ���½��ͣ�
 * main����ִ�е�synchronized main��0��,�����������Դ����������Ϊ�գ���bool = true��ִ��this.wait��������  �ͷ������� ����ȴ����ȴ���
 * ʱ��Ƭ��ת��subִ��synchronized sub��0���������������Դ����������Ϊ�գ���bool = false,˳��ִ����2��ѭ������bool = false,��֪ͨmain����������У���ʱsub��ӵ���������󣩣�ִ��sub��2��������Ⱥ���У��ͷ�������
 * main��ȡ������ִ��main��0��4��forѭ������������������
 */
