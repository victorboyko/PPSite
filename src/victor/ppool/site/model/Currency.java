package victor.ppool.site.model;

public class Currency {
	private int id;
	private int algo_id;
	private Algo algo;
	private String Abr;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAlgo_id() {
		return algo_id;
	}

	public void setAlgo_id(int algo_id) {
		this.algo_id = algo_id;
	}

	public Algo getAlgo() {
		return algo;
	}

	public void setAlgo(Algo algo) {
		this.algo = algo;
	}

	public String getAbr() {
		return Abr;
	}

	public void setAbr(String abr) {
		Abr = abr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
