package tjc.bandung.model.entity.response;


import org.springframework.data.domain.Sort;


public class PaginationResponse {

	private boolean last;
	private int totalPages;
	private long totalElements;
	private Sort sort;
	private boolean first;
	private int numberOfElements;
	private int size;
	private int number;
	private long lastId;

	/**
	 * @return
	 */
	public long getLastId() {
		return lastId;
	}

	/**
	 * @return
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return
	 */
	public int getNumberOfElements() {
		return numberOfElements;
	}

	/**
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return
	 */
	public Sort getSort() {
		return sort;
	}

	/**
	 * @return
	 */
	public long getTotalElements() {
		return totalElements;
	}

	/**
	 * @return
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @return
	 */
	public boolean isFirst() {
		return first;
	}

	/**
	 * @return
	 */
	public boolean isLast() {
		return last;
	}

	/**
	 * @param first
	 */
	public void setFirst(final boolean first) {
		this.first = first;
	}

	/**
	 * @param last
	 */
	public void setLast(final boolean last) {
		this.last = last;
	}

	/**
	 * @param lastId
	 */
	public void setLastId(final long lastId) {
		this.lastId = lastId;
	}

	/**
	 * @param number
	 */
	public void setNumber(final int number) {
		this.number = number;
	}

	/**
	 * @param numberOfElements
	 */
	public void setNumberOfElements(final int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	/**
	 * @param size
	 */
	public void setSize(final int size) {
		this.size = size;
	}

	/**
	 * @param sort
	 */
	public void setSort(final Sort sort) {
		this.sort = sort;
	}

	/**
	 * @param totalElements
	 */
	public void setTotalElements(final long totalElements) {
		this.totalElements = totalElements;
	}

	/**
	 * @param totalPages
	 */
	public void setTotalPages(final int totalPages) {
		this.totalPages = totalPages;
	}
}
