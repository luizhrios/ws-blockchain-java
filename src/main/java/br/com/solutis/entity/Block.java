package br.com.solutis.entity;

import java.util.Date;

public class Block extends Miner {

	private static int _index;

	private int index;
	private Date timestamp;
	private String data;
	private String hash;
	private String preHash;

	public Block() {
		this.index = _index++;
		this.timestamp = new Date();
		this.hash = hashGenerator(index, null, timestamp);
	}

	@Override
	public String toString() {
		return "Block{" +
				"index=" + index +
				", nounce='" + getNounce() + '\'' +
				", data='" + data + '\'' +
				'}';
	}

	public Block(String data) {
		this.index = _index++;
		this.timestamp = new Date();
		this.data = data;
		this.hash = hashGenerator(index, data, timestamp);
	}

	public int getIndex() {
		return index;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getHash() {
		return hash;
	}

	public String getPreHash() {
		return preHash;
	}

	public void setPreHash(String preHash) {
		this.preHash = preHash;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
