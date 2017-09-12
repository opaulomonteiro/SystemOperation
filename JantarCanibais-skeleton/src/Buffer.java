public class  Buffer {
	int porcoes;
	public Buffer() {};
	public int getPorcoes() {
		return porcoes;
	}
	public void setPorcoes(int porcoes) {
		this.porcoes = porcoes;
	}
	public synchronized void retira(int num) {
		this.porcoes = this.porcoes - num;
	}
	public synchronized void deposita (int num) {
		this.porcoes = this.porcoes + num;	
	}
}