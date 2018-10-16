package tjc.bandung.model.enums;



public enum ResponseCode {
	/*
	 * SUCCESS
	 */
	SUCCESS(200),
	/*
	 * FAILED used if there is any invalid input
	 */
	FAILED(99), INTERNAL_SERVER_ERROR(500), URL_NOT_FOUND(404), BAD_REQUEST(400),
	/*
	 * EXCEPTION used only for unexpected response
	 */
	EXCEPTION(98);

	private int value = 200;

	/**
	 * @param value
	 */
	private ResponseCode(final int value) {
		this.value = value;
	}

	/*
	 * Setter and Getter
	 */
	/**
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 */
	public void setValue(final int value) {
		this.value = value;
	}
}
