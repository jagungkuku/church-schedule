package tjc.bandung.model.enums;


import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import tjc.bandung.model.enums.serializer.ResponseMessageDeserializer;
import tjc.bandung.model.enums.serializer.ResponseMessageSerializer;


/**
 * enums for response message this enum will be integrated with application
 * properties
 * 
 * @see <i>message.properties</i> in resource
 *
 *
 *
 * 
 *
 */
@JsonSerialize(using = ResponseMessageSerializer.class)
@JsonDeserialize(using = ResponseMessageDeserializer.class)
public enum ResponseMessage {
	ACK_APP_001(1, "ack.app.001"), ACK_APP_002(2, "ack.app.002"), ACK_APP_003(3, "ack.app.003"), ACK_APP_004(4,
			"ack.app.004"), ACK_APP_005(5, "ack.app.005"), ACK_APP_006(6,
					"ack.app.006"), ACK_APP_007(7, "ack.app.007"), ACK_APP_008(8, "ack.app.008"),

	ERR_APP_001(1, "err.app.001"), ERR_APP_002(2, "err.app.002"), ERR_APP_003(3, "err.app.003"), ERR_APP_004(4,
			"err.app.004"), ERR_APP_005(5, "err.app.005"), ERR_APP_006(6, "err.app.006"), ERR_APP_007(7,
					"err.app.007"), ERR_APP_008(8, "err.app.008"), ERR_APP_009(9, "err.app.009"), ERR_APP_010(10,
							"err.app.010"), ERR_APP_011(11, "err.app.011"), ERR_APP_012(12, "err.app.012"), ERR_APP_013(
									13, "err.app.013"), ERR_APP_014(14, "err.app.014"), ERR_APP_015(15,
											"err.app.015"), ERR_APP_016(16, "err.app.016"), ERR_APP_017(17,
													"err.app.017"), ERR_APP_018(18, "err.app.018"), ERR_APP_019(19,
															"err.app.019"), ERR_APP_020(20, "err.app.020"), ERR_APP_021(
																	21, "err.app.021"), ERR_APP_999(999, "err.app.999");

	private String value = "";
	private String field = "";
	private int code;

	/**
	 * @param code
	 * @param value
	 */
	private ResponseMessage(final int code, final String value) {
		this.value = value;
		this.code = code;
	}

	/**
	 * @return
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return
	 */
	public String getField() {
		return field;
	}

	/*
	 * Setter and Getter
	 */
	/**
	 * @return
	 */
	@JsonValue
	public String getValue() {
		return value;
	}

	/**
	 * @param code
	 */
	public void setCode(final int code) {
		this.code = code;
	}

	/**
	 * @param field
	 */
	public void setField(final String field) {
		this.field = field;
	}

	/**
	 * @param value
	 */
	public void setValue(final String value) {
		this.value = value;
	}
}
