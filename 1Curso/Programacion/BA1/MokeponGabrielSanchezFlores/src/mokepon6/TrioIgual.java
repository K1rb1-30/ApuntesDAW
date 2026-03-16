package mokepon6;

public class TrioIgual<T> {
	
	private T primer;
	private T segon;
	private T tercer;
	
	public TrioIgual(T primer, T segon, T tercer) {
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

	public T getSegon() {
		return segon;
	}

	public void setSegon(T segon) {
		this.segon = segon;
	}

	public T getTercer() {
		return tercer;
	}

	public void setTercer(T tercer) {
		this.tercer = tercer;
	}

}
