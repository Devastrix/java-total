package training.concurrency.threadlocal;

public class ThreadLocalDemo {

	public static UserDataHolder holder = new UserDataHolder();
	public static void main(String[] args) {
		SomeThread t1 = new SomeThread();
		SomeThread t2 = new SomeThread();
		t1.start();
		t2.start();

	}

}

class SomeThread extends Thread{
	
	DataAccessLayer dao = new DataAccessLayer();
	@Override
	public void run() {
		UserData user = ThreadLocalDemo.holder.get();
		System.out.println("Accessing userdata for "+user.getUserName());
		dao.accessData();
	}
}

class DataAccessLayer{
	
	public void accessData(){
		UserData user = ThreadLocalDemo.holder.get();
		System.out.println("********In dao user name is "+user.getUserName());
	}
}