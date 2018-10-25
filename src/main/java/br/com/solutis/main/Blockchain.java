package br.com.solutis.main;

import br.com.solutis.entity.Block;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {

	private List<Block> blockList = new ArrayList<>();
	private static int _lastBlock;

	public Blockchain() {
		Block block = new Block();
		blockList.add(block);
	}

	public void addBlock(Block block) {
		block.setPreHash(getLatestBlock().getHash());
		if (validateChain(block)) {
			blockList.add(block);
			_lastBlock++;
		}
	}

	public boolean validateChain(Block block) {
		Block preBlock = getBlockByIndex(block.getIndex() - 1);
		if (block.hashGenerator(block.getIndex(), block.getData(), block.getTimestamp()).equals(block.getHash()))
			if (preBlock.hashGenerator(preBlock.getIndex(), preBlock.getData(), preBlock.getTimestamp()).equals(block.getPreHash()))
				for (Block blockInList : blockList) {
					if (blockInList.hashGenerator(blockInList.getIndex(), blockInList.getData(), blockInList.getTimestamp()).equals(blockInList.getHash()))
						return true;
				}
		return false;
	}

	public Block getBlockByIndex(int index) {
		return blockList.get(index);
	}

	public Block getLatestBlock() {
		return blockList.get(_lastBlock);
	}

	public List<Block> getChain() {
		return blockList;
	}
}
