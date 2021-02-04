package com.urban.spatium.dto;

public class Board extends Common{
	private int boardIdx;
	private String boardAddId;
	private int boardCate;
	private String boardTitle;
	private String boardContents;
	private int boardLikeCnt;
	private int boardHitCnt;
	private String boardAddDate;
	private String boardUpDate;
	private String boardDeclaration;
	private String boardBlind;
	
	private BoardReply boardReply;
	
	
	private User user; 
	
	
	private int boardCateCode;
	private String boardCateName;
	
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
	public int getBoardCate() {
		return boardCate;
	}
	public void setBoardCate(int boardCate) {
		this.boardCate = boardCate;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}
	public int getBoardLikeCnt() {
		return boardLikeCnt;
	}
	public void setBoardLikeCnt(int boardLikeCnt) {
		this.boardLikeCnt = boardLikeCnt;
	}
	public int getBoardHitCnt() {
		return boardHitCnt;
	}
	public void setBoardHitCnt(int boardHitCnt) {
		this.boardHitCnt = boardHitCnt;
	}
	public String getBoardAddDate() {
		return boardAddDate;
	}
	public void setBoardAddDate(String boardAddDate) {
		this.boardAddDate = boardAddDate;
	}
	public String getBoardUpDate() {
		return boardUpDate;
	}
	public void setBoardUpDate(String boardUpDate) {
		this.boardUpDate = boardUpDate;
	}
	public String getBoardDeclaration() {
		return boardDeclaration;
	}
	public void setBoardDeclaration(String boardDeclaration) {
		this.boardDeclaration = boardDeclaration;
	}
	public String getBoardBlind() {
		return boardBlind;
	}
	public void setBoardBlind(String boardBlind) {
		this.boardBlind = boardBlind;
	}
	@Override
	public String toString() {
		return "Board [boardIdx=" + boardIdx + ", boardAddId=" + boardAddId + ", boardCate=" + boardCate
				+ ", boardTitle=" + boardTitle + ", boardContents=" + boardContents + ", boardLikeCnt=" + boardLikeCnt
				+ ", boardHitCnt=" + boardHitCnt + ", boardAddDate=" + boardAddDate + ", boardUpDate=" + boardUpDate
				+ ", boardDeclaration=" + boardDeclaration + ", boardBlind=" + boardBlind + ", getBoardIdx()="
				+ getBoardIdx() + ", getBoardAddId()=" + getBoardAddId() + ", getBoardCate()=" + getBoardCate()
				+ ", getBoardTitle()=" + getBoardTitle() + ", getBoardContents()=" + getBoardContents()
				+ ", getBoardLikeCnt()=" + getBoardLikeCnt() + ", getBoardHitCnt()=" + getBoardHitCnt()
				+ ", getBoardAddDate()=" + getBoardAddDate() + ", getBoardUpDate()=" + getBoardUpDate()
				+ ", getBoardDeclaration()=" + getBoardDeclaration() + ", getBoardBlind()=" + getBoardBlind()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	public int getBoardCateCode() {
		return boardCateCode;
	}
	public void setBoardCateCode(int boardCateCode) {
		this.boardCateCode = boardCateCode;
	}
	public String getBoardCateName() {
		return boardCateName;
	}
	public void setBoardCateName(String boardCateName) {
		this.boardCateName = boardCateName;
	}
	
	
	
	public BoardReply getBoardReply() {
		return boardReply;
	}
	public void setBoardReply(BoardReply boardReply) {
		this.boardReply = boardReply;
	}
	
	
}
