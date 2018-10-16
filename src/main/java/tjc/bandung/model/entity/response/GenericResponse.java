package tjc.bandung.model.entity.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import tjc.bandung.model.enums.ResponseCode;
import tjc.bandung.model.enums.ResponseMessage;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@JsonInclude(Include.NON_NULL)
public class GenericResponse implements Serializable {
	private static final Logger LOG = Logger.getLogger(GenericResponse.class);

	private static final long serialVersionUID = -5560351027550549940L;
	private Object data;
	private Object error;
	private PaginationResponse pagination;

	private Object message;
	private List<ResponseMessage> responseMessage;

	private ResponseCode status;

	/**
	 * @param responseMessage
	 * @param status
	 */
	public GenericResponse(final List<ResponseMessage> responseMessage, final ResponseCode status) {
		this.responseMessage = responseMessage;
		this.status = status;
	}

	/**
	 * @param data
	 * @param status
	 */
	public GenericResponse(final Object data, final ResponseCode status) {
		this.data = data;
		this.status = status;
	}

	/**
	 * @param data
	 * @param lastId
	 * @param status
	 */
	public GenericResponse(final Page<?> data, final long lastId, final ResponseCode status) {
		this.data = data.getContent();
		pagination = new PaginationResponse();
		pagination.setFirst(data.isFirst());
		pagination.setLast(data.isLast());
		pagination.setNumber(data.getNumber());
		pagination.setNumberOfElements(data.getNumberOfElements());
		pagination.setSize(data.getSize());
		pagination.setSort(data.getSort());
		pagination.setTotalElements(data.getTotalElements());
		pagination.setTotalPages(data.getTotalPages());
		pagination.setLastId(lastId);

		this.status = status;
	}
	
	/**
	 * @param data
	 * @param status
	 */
	public GenericResponse(final Page<?> data, final ResponseCode status) {
		this.data = data.getContent();
		pagination = new PaginationResponse();
		pagination.setFirst(data.isFirst());
		pagination.setLast(data.isLast());
		pagination.setNumber(data.getNumber());
		pagination.setNumberOfElements(data.getNumberOfElements());
		pagination.setSize(data.getSize());
		pagination.setSort(data.getSort());
		pagination.setTotalElements(data.getTotalElements());
		pagination.setTotalPages(data.getTotalPages());

		this.status = status;
	}

	/**
	 * @param status
	 */
	public GenericResponse(final ResponseCode status) {
		this.status = status;
	}

	/**
	 * @param message
	 * @param status
	 */
	public GenericResponse(final String message, final ResponseCode status) {

		this.message = message;
		this.status = status;
	}

	/**
	 * @param responseMessage
	 */
	public void addResponseMessage(final ResponseMessage responseMessage) {
		if (this.responseMessage == null) {
			this.responseMessage = new ArrayList<>();
		}
		this.responseMessage.add(responseMessage);
	}

	/**
	 * @return
	 */
	public int getCode() {
		return status.getValue();
	}

	/**
	 * @return
	 */
	public Object getData() {
		return data;
	}

	/**
	 * get the class object convert from json response
	 * 
	 * @param className
	 * @return className
	 */
	@JsonIgnore
	public <T> T getData(final Class<T> className) {
		Object obj = new Object();
		if (data instanceof JSONObject) {
			try {
				final ObjectMapper mapper = new ObjectMapper();
				obj = mapper.readValue(data.toString(), className);
				
			} catch (final StackOverflowError e) {
				LOG.error("className do not match with json object :" + e.getMessage());
			} catch (final JsonParseException e) {
				LOG.error("className do not match with json object :" + e.getMessage());
			} catch (final JsonMappingException e) {
				LOG.error("className do not match with json object :" + e.getMessage());
			} catch (final IOException e) {
				LOG.error("className do not match with json object :" + e.getMessage());
			}
		}
		return className.cast(obj);
	}

	/**
	 * @return
	 */
	public Object getError() {
		return error;
	}

	/**
	 * get the class object convert from json response
	 * 
	 * @param className
	 * @return className
	 */
	@SuppressWarnings("unchecked")
	@JsonIgnore
	public <T> List<T> getList(final Class<T[]> className) {
		T[] arr = (T[])Array.newInstance(className, 0);
		if (data instanceof JSONArray) {
			try {
				final ObjectMapper mapper = new ObjectMapper();
				arr = mapper.readValue(data.toString(), className);
				// T[] arr = gson.fromJson(yourMap, className);
				
			} catch (final StackOverflowError e) {
				LOG.error("className do not match with json array object " + e.getMessage());
			} catch (final JsonParseException e) {
				LOG.error("className do not match with json array object " + e.getMessage());
			} catch (final JsonMappingException e) {
				LOG.error("className do not match with json array object " + e.getMessage());
			} catch (final IOException e) {
				LOG.error("className do not match with json array object " + e.getMessage());
			}
		}
		
		return Arrays.asList(arr);	
		
	}

	/**
	 * @return
	 */
	public Object getMessage() {
		return message;
	}

	/**
	 * @return
	 */
	public PaginationResponse getPagination() {
		return pagination;
	}

	/**
	 * @return
	 */
	public List<ResponseMessage> getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @return
	 */
	public ResponseCode getStatus() {
		return status;
	}

	/**
	 * @param code
	 */
	public void setCode(final int code) {
		// return this.status.getValue();
	}

	/**
	 * @param data
	 */
	public void setData(final Object data) {
		this.data = data;
	}

	/**
	 * @param error
	 */
	public void setError(final Object error) {
		this.error = error;
	}

	/**
	 * @param message
	 */
	public void setMessage(final Object message) {
		this.message = message;
	}

	/**
	 * @param pagination
	 */
	public void setPagination(final PaginationResponse pagination) {
		this.pagination = pagination;
	}

	/**
	 * @param responseMessage
	 */
	public void setResponseMessage(final List<ResponseMessage> responseMessage) {
		this.responseMessage = responseMessage;
	}

	/**
	 * @param status
	 */
	public void setStatus(final ResponseCode status) {
		this.status = status;
	}
}
