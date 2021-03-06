package ex0605.kosta.mvc.model.dto;

public class BoardDTO {

	private int boardNo; // 글번호
	private String subject; // 제목
	private String writer; // 작성자
	private String content; // 내용
	private String boardDate; // 등록일
	
	public BoardDTO() {
		
	}
	
	public BoardDTO(String subject, String writer, String content, String boardDate) {
		this.subject = subject;
		this.writer = writer;
		this.content = content;
		this.boardDate = boardDate;
	}

	public BoardDTO(int boardNo, String subject, String writer, String content, String boardDate) {
		this(subject, writer, content, boardDate);
		this.boardNo = boardNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	@Override
	public String toString() {
		return boardNo + " | " + writer + "|" + subject + "|" + "|" + content + "|" + boardDate;
	}
}
