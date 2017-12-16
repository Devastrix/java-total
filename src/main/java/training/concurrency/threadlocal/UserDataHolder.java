package training.concurrency.threadlocal;

public class UserDataHolder extends ThreadLocal<UserData> {
	
	@Override
	protected UserData initialValue() {
		System.out.println("Creating a userData obj for thread "+
				Thread.currentThread().getName());
		return new UserData(Thread.currentThread().getName()+"-user");
	}

}
