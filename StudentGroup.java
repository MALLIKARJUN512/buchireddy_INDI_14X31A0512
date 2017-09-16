import java.util.Date;
import java.util.ArrayList;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	private ArrayList studList=new ArrayList<Student>();
	private Student[] studs;
	private int i,j;
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		
		for(i=0;i<students.length;i++)
			if(students[i].id!=-1) studList.add(students[i]);
		if(studList.size()>0) 
		{
			studs=studList.toArray(studs);
			return studs;
		}
		return null;
	}

	@Override
	public void setStudents(Student[] students) {
		if(students==null) throw new IllegalArgumentException("no data");
		this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		if(index<0 || index>=students.length) throw new IllegalArgumentException("no data");
		if(students.length==0 || students[index].id==-1) return null;
		else return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		if(student==null || index==0 || index>=students.length) throw new IllegalArgumentException("no data");
		students[index]=student;
	}

	@Override
	public void addFirst(Student student) {
		if(students==null) throw new IllegalArgumentException("no data");
		students[0]=student;
	}

	@Override
	public void addLast(Student student) {
		if(students==null) throw new IllegalArgumentException("no data");
		students[students.length-1]=student;
	}

	@Override
	public void add(Student student, int index) {
		if(student==null || index<0 || index>=students.length) throw new IllegalArgumentException("no data");
	}

	@Override
	public void remove(int index) {
		if(index<0 || index>=students.length || students.length==0) throw new IllegalArgumentException("no data");
		students[index].id=-1;
	}

	@Override
	public void remove(Student student) {
		if(student==null || students.length==0) throw new IllegalArgumentException("no data");
		boolean exists=false;
		for(i=0;i<students.length;i++)
			if(students[i].equals(student))
			{
				students[i].id=-1;
				exists=true;
				break;
			}
		if(exists==false) throw new IllegalArgumentException("Student not exists");
	}

	@Override
	public void removeFromIndex(int index) {
		if(index<=0 || index>=students.length || students.length==0) throw new IllegalArgumentException("no data");
		for(i=index+1;i<students.length;i++)
			students[i].id=-1;
	}

	@Override
	public void removeFromElement(Student student) {
		if(student==null || students.length==0) throw new IllegalArgumentException("no data");
		for(i=0;i<students.length;i++)
			if(students[i].equals(student))
			{
				for(j=i+1;j<students.length;j++)
					students[j].id=-1;
				break;
			}
	}

	@Override
	public void removeToIndex(int index) {
		if(index<0 || index>=students.length || students.length==0) throw new IllegalArgumentException("no data");
		for(i=0;i<index;i++)
			students[i].id=-1;
	}

	@Override
	public void removeToElement(Student student) {
		if(student==null || students.length==0) throw new IllegalArgumentException("no data");
		for(int i=0;i<students.length;i++)
			if(students[i].equals(student))
			{
				for(j=0;j<i;j++)
					students[j].id=-1;
				break;
			}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		if(date==null || students.length==0) throw new IllegalArgumentException("no data");
		studList=new ArrayList<Student>();
		for(i=0;i<students.length;i++)
		{
			if(students[i].getBirthDate().before(date) || students[i].getBirthDate().equals(date))
			studList.add(students[i]);
		}
		if(studList.size()>0) return studs=studList.toArray(studs);
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		if(firstDate==null || lastDate==null || students.length==0) throw new IllegalArgumentException("no data");
		studList=new ArrayList<Student>();
		for(i=0;i<students.length;i++)
		{
			if(students[i].getBirthDate().equals(firstDate) || students[i].getBirthDate().equals(lastDate) || students[i].getBirthDate().after(firstDate) && students[i].getBirthDate().before(lastDate))
				studList.add(students[i]);
		}
		if(studList.size()>0) return studs=studList.toArray(studs);
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		if(date==null || students.length==0) throw new IllegalArgumentException("no data");
		studList=new ArrayList<Student>();
		long millis=date.getTime()+((days*24*60*60)/1000);
		Date dt=new Date(millis);
		java.util.Calendar cal=java.util.Calendar.getInstance();
		for(i=0;i<students.length;i++)
			if(students[i].getBirthDate().equals(date) || dt.after(students[i].getBirthDate()))
				studList.add(students[i]);
		if(studList.size()>0) return studs=studList.toArray(studs);
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		if(indexOfStudent==0) throw new IllegalArgumentException("no data");
		   int ind=indexOfStudent;
		   java.util.Calendar cal=java.util.Calendar.getInstance();
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		//
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		if(students==null) throw new IllegalArgumentException("no data");
		return null;
	}
}
