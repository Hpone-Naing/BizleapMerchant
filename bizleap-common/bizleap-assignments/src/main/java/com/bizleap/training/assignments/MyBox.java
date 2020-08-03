package com.bizleap.training.assignments;
//tutorial26
import com.bizleap.training.tutorial22.Gender;
import com.bizleap.training.tutorial22.Student;

public class MyBox<T> {

	private T item;
	
	public MyBox() {
		
	}
	
    public MyBox(T item) {
    	this.item=item;
    }
	@Override
	public String toString() {
		return new StringBuilder().append(item).toString();
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public static void main(String[] args) {
		
		MyBox<String> stringObj=new MyBox<String>("1");
		System.out.println("Assign String:" + stringObj);
		
		MyBox<Integer> intObj=new MyBox<Integer>(1);
		System.out.println("Assign Integer:" + intObj);
		
		MyBox<Double> doubleObj=new MyBox<Double>(1.999);
		System.out.println("Assign Double:" + doubleObj);
		
		MyBox<Float> floatObj=new MyBox<Float>((float)1.1);
		System.out.println("Assign Float:" + floatObj);
		
		MyBox<Long> longObj=new MyBox<Long>((long)9999);
		System.out.println("Assign Long:" + longObj);
		
		MyBox<Boolean> booleanObj=new MyBox<Boolean>(false);
		System.out.println("Assign Boolean:" + booleanObj);
		
		MyBox<Teacher> teacherObj=new MyBox<Teacher>(new Teacher("Daw Nwe","nwe@gmail.com",Gender.FEMALE));
		System.out.println("Assign Teacher:" + teacherObj);
		
		MyBox<Student> studentObj=new MyBox<Student>(new Student("Moe Aung",Gender.MALE,"moe@gmail.com"));
		System.out.println("Assign Student:" + studentObj);

	}

}
