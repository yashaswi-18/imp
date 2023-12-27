package day4.bean;

public class Course {

	private int courseId;
	   private String title;
	   private int duration ;
	   private String provider;
	   private int fees;
	   
	   public Course(int courseId)
	   {
		   this.courseId=courseId;	   }
	   
	public Course(int courseId, String title, int duration, String provider, int fees) {
		super();
		this.courseId = courseId;
		this.title = title;
		this.duration = duration;
		this.provider = provider;
		this.fees = fees;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public Course() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", title=" + title + ", duration=" + duration + ", provider=" + provider
				+ ", fees=" + fees + "]";
	}
	

}
