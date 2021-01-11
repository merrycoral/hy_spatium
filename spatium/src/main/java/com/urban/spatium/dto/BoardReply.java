package com.urban.spatium.dto;

public class BoardReply {
	
	private Board board;

	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	
	private int replyIdx;
	private int boardIdx;
	private String boardAddId;
	private String replyContents;
	private int replyLikeCnt;
	private String replyAddId;
	private String replyAddDate;
	private String replyUpDate;
	private String replyDeclaration;
	private String replyBlind;
	
	

	public int getReplyIdx() {
		return replyIdx;
	}
	public void setReplyIdx(int replyIdx) {
		this.replyIdx = replyIdx;
	}
	public int getBoardIdx() {
		return boardIdx;
	}
	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}
	public String getBoardAddId() {
		return boardAddId;
	}
	public void setBoardAddId(String boardAddId) {
		this.boardAddId = boardAddId;
	}
	public String getReplyContents() {
		return replyContents;
	}
	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}
	public int getReplyLikeCnt() {
		return replyLikeCnt;
	}
	public void setReplyLikeCnt(int replyLikeCnt) {
		this.replyLikeCnt = replyLikeCnt;
	}
	public String getReplyAddId() {
		return replyAddId;
	}
	public void setReplyAddId(String replyAddId) {
		this.replyAddId = replyAddId;
	}
	public String getReplyAddDate() {
		return replyAddDate;
	}
	public void setReplyAddDate(String replyAddDate) {
		this.replyAddDate = replyAddDate;
	}
	public String getReplyUpDate() {
		return replyUpDate;
	}
	public void setReplyUpDate(String replyUpDate) {
		this.replyUpDate = replyUpDate;
	}
	public String getReplyDeclaration() {
		return replyDeclaration;
	}
	public void setReplyDeclaration(String replyDeclaration) {
		this.replyDeclaration = replyDeclaration;
	}
	public String getReplyBlind() {
		return replyBlind;
	}
	public void setReplyBlind(String replyBlind) {
		this.replyBlind = replyBlind;
	}
	@Override
	public String toString() {
		return "BoardReply [replyIdx=" + replyIdx + ", boardIdx=" + boardIdx + ", boardAddId=" + boardAddId
				+ ", replyContents=" + replyContents + ", replyLikeCnt=" + replyLikeCnt + ", replyAddId=" + replyAddId
				+ ", replyAddDate=" + replyAddDate + ", replyUpDate=" + replyUpDate + ", replyDeclaration="
				+ replyDeclaration + ", replyBlind=" + replyBlind + ", getReplyIdx()=" + getReplyIdx()
				+ ", getBoardIdx()=" + getBoardIdx() + ", getBoardAddId()=" + getBoardAddId() + ", getReplyContents()="
				+ getReplyContents() + ", getReplyLikeCnt()=" + getReplyLikeCnt() + ", getReplyAddId()="
				+ getReplyAddId() + ", getReplyAddDate()=" + getReplyAddDate() + ", getReplyUpDate()="
				+ getReplyUpDate() + ", getReplyDeclaration()=" + getReplyDeclaration() + ", getReplyBlind()="
				+ getReplyBlind() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
	
}
