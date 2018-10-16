package tjc.bandung.model.enums.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import tjc.bandung.model.enums.ResponseMessage;
import tjc.bandung.model.enums.properties.PropertiesUtil;

import java.io.IOException;


public class ResponseMessageSerializer extends StdSerializer<ResponseMessage> {

	/**
	 *
	 */
	private static final long serialVersionUID = -693056094060814002L;

	/**
	 * 
	 */
	@Autowired
	private PropertiesUtil propertiesUtil;

	/**
	 * 
	 */
	public ResponseMessageSerializer() {
		this(null);
	}

	/**
	 * @param resp
	 */
	public ResponseMessageSerializer(final Class<ResponseMessage> resp) {
		super(resp);
	}

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.ser.std.StdSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
	 */
	@Override
	public void serialize(final ResponseMessage value, final JsonGenerator generator, final SerializerProvider provider)
			throws IOException, JsonProcessingException {
		generator.writeStartObject();
		generator.writeFieldName("code");
		generator.writeNumber(value.getCode());
		generator.writeFieldName("key");
		generator.writeString(value.name());
		generator.writeFieldName("field");
		generator.writeString(value.getField());
		generator.writeFieldName("message");
		if (propertiesUtil == null || value.getValue() == null) {
			generator.writeString("");
		} else {
			generator.writeString(propertiesUtil.getMessage().get(value.getValue()));
		}
		generator.writeEndObject();
	}
}