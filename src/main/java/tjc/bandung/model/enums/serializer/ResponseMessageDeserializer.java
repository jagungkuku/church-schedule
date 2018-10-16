package tjc.bandung.model.enums.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import tjc.bandung.model.enums.ResponseMessage;

import java.io.IOException;


public class ResponseMessageDeserializer extends StdDeserializer<ResponseMessage> {
	private static final long serialVersionUID = -693056094060814002L;

	public ResponseMessageDeserializer() {
		this(null);
	}

	public ResponseMessageDeserializer(final Class<ResponseMessage> resp) {
		super(resp);
	}

	@Override
	public ResponseMessage deserialize(final JsonParser parser, final DeserializationContext arg1)
			throws IOException, JsonProcessingException {

		final JsonNode node = parser.getCodec().readTree(parser);
		final String key = node.get("key").asText();
		
		return ResponseMessage.valueOf(key);
	}
}