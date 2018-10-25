package br.com.solutis.entity;

import br.com.solutis.util.Hash;

import java.util.Date;

public class Miner {

	private int nounce;

	public String hashGenerator(int index, String data, Date timestamp) {
		String hash;
		hash = Hash.getSha256(index + data + timestamp.toString() + nounce);
		while (!hash.startsWith("000")) {
			hash = Hash.getSha256(index + data + timestamp.toString() + ++nounce);
		}
		return hash;
	}

	public int getNounce() {
		return nounce;
	}
}
