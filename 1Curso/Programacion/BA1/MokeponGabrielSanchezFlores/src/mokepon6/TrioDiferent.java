package mokepon6;

public class TrioDiferent<T,U,V> {
	
	private T primer;
	private U segon;
	private V tercer;
	
    public TrioDiferent(T primer, U segon, V tercer) {
        this.primer = primer;
        this.segon = segon;
        this.tercer = tercer;
    }
    
	public T getPrimer() {
		return primer;
	}
	public void setPrimer(T primer) {
		this.primer = primer;
	}
	public U getSegon() {
		return segon;
	}
	public void setSegon(U segon) {
		this.segon = segon;
	}
	public V getTercer() {
		return tercer;
	}
	public void setTercer(V tercer) {
		this.tercer = tercer;
	}
	
	

}
